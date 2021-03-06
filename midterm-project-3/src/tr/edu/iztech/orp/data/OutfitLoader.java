package tr.edu.iztech.orp.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tr.edu.iztech.orp.enums.OutfitColor;
import tr.edu.iztech.orp.enums.OutfitGender;
import tr.edu.iztech.orp.enums.OutfitOccasion;
import tr.edu.iztech.orp.enums.OutfitSize;
import tr.edu.iztech.orp.enums.OutfitType;
import tr.edu.iztech.orp.models.Comment;
import tr.edu.iztech.orp.models.Outfit;
import org.json.*;

public class OutfitLoader implements IDataLoader<Outfit> {
	private final String path;
	
	public OutfitLoader(String pathname) {
		this.path = pathname;
	}
	
	@Override
	public List<Outfit> load() {
		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener tokener = new JSONTokener(is);
        JSONArray object = new JSONArray(tokener);
        
		List<Outfit> outfits = new ArrayList<>();

		for(Object obj: object) {
			JSONObject jsonField = (JSONObject) obj;
			
			int outfitId = jsonField.getInt("outfit_id");
			String name = jsonField.getString("name");
			String brandName = jsonField.getString("brand_name");

			OutfitGender gender = OutfitGender.valueOf(jsonField.getString("gender"));
			OutfitType type = OutfitType.valueOf(jsonField.getString("type"));
			OutfitOccasion occasion = OutfitOccasion.valueOf(jsonField.getString("occasion"));
			OutfitColor color = OutfitColor.valueOf(jsonField.getString("color"));
			
			JSONArray sizeJsonArray = jsonField.getJSONArray("available_sizes");
			List<OutfitSize> sizes = new LinkedList<>();
			for(Object size: sizeJsonArray) {
				sizes.add(OutfitSize.valueOf(size.toString()));
			}
			Outfit outfit = new Outfit(outfitId, name, brandName, gender, type, occasion, color, sizes.toArray(OutfitSize[]::new));

			JSONArray commentJsonArray = jsonField.getJSONArray("comments");
			for(Object commentObject: commentJsonArray) {
				JSONObject comment = (JSONObject) commentObject;
				String authorId = comment.getString("author");
				String message = comment.getString("text");
				outfit.addComment(new Comment(authorId, message));
			}
			
			JSONArray likedJsonArray = jsonField.getJSONArray("liked_users");
			for(Object user: likedJsonArray) {
				outfit.addLike(user.toString());
			}
			
			JSONArray dislikedJsonArray = jsonField.getJSONArray("disliked_users");
			for(Object user: dislikedJsonArray) {
				outfit.addDislike(user.toString());
			}

			outfits.add(outfit);
		}

		return outfits;
	}
}
