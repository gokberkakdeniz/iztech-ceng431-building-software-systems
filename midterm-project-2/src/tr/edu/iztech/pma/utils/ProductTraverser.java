package tr.edu.iztech.pma.utils;

import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class ProductTraverser {

    public static void traverse(IProduct root) {
        traverse(root, p -> { System.out.printf("%s\t", p.toString()); });
    }

    /**
     * traverses the product tree.
     */
    public static void traverse(IProduct root, Consumer<IProduct> consumer) {
        Queue<IProduct> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            boolean first = true;

            while (n > 0)
            {
                IProduct p = queue.poll();

                if (first) {
                    if (p.hasParent()) System.out.print(p.getParent().getId() + ": ");
                    else System.out.print("-: ");
                    first = false;
                }

                consumer.accept(p);

                if (p instanceof AbstractProductWithChildren) {
                    List<IProduct> children = ((AbstractProductWithChildren)p).getChildren();
                    queue.addAll(children);
                }
                n--;
            }

            // Print new line between two levels
            System.out.println();
        }
    }
}
