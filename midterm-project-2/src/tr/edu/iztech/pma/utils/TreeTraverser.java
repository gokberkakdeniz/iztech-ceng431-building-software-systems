package tr.edu.iztech.pma.utils;

import tr.edu.iztech.pma.product.AbstractProductWithChildren;
import tr.edu.iztech.pma.product.IProduct;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class TreeTraverser {

    public static void traverse(IProduct root) {
        traverse(root, p -> { System.out.printf("%s(id: %d) ", p.getTitle(), p.getId()); });
    }

    public static void traverse(IProduct root, Consumer<IProduct> consumer) {
        Queue<IProduct> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            boolean first = true;

            // If this node has children
            while (n > 0)
            {
                // Dequeue an item from queue
                // and print it
                IProduct p = queue.peek();
                queue.remove();

                if (first) {
                    if (p.hasParent()) System.out.print(p.getParent().getId() + ": ");
                    else System.out.print("-: ");
                    first = false;
                }

                consumer.accept(p);

                // Enqueue all children of
                // the dequeued item
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
