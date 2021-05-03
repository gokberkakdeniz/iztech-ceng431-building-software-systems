package tr.edu.iztech.orp.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.*;

import tr.edu.iztech.orp.models.Outfit;

public class OutfitSaver implements IDataSaver<Outfit> {
	private final File file;
	
	public OutfitSaver(String pathname) {
		this.file = new File(pathname);
	}

	@Override
	public void save(List<Outfit> data) {
		JSONArray list = new JSONArray();
		
		JSONObject outfitJson;
		for (Outfit outfit: data) {
			outfitJson = new JSONObject();
			
			outfitJson.put("outfit_id", outfit.getId());
			outfitJson.put("name", outfit.getName());
			outfitJson.put("brand_name", outfit.getBrandName());
			outfitJson.put("gender", outfit.getGender());
			outfitJson.put("type", outfit.getType());
			outfitJson.put("color", outfit.getColor());
			outfitJson.put("available_sizes", outfit.getSizes());
			outfitJson.put("occasion", outfit.getOccasion());
			outfitJson.put("comments", outfit.getComments());
			outfitJson.put("liked_users", outfit.getLikedUserIds());
			outfitJson.put("disliked_users", outfit.getDislikedUserIds());
			
			list.put(outfitJson);
		}
				
		try {
			FileWriter myFile = new FileWriter(file);
			myFile.write(list.toString(2));
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
