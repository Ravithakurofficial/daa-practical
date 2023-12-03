import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class huffmancode {
    static HashMap<Character, String> huffmanCodes = new HashMap<>();

    public static void buildHuffmanTree(char[] characters, int[] frequencies) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < characters.length; i++) {
            HuffmanNode node = new HuffmanNode(characters[i], frequencies[i]);
            priorityQueue.add(node);
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode mergedNode = new HuffmanNode('\0', left.frequency + right.frequency);
            mergedNode.left = left;
            mergedNode.right = right;

            priorityQueue.add(mergedNode);
        }

        buildHuffmanCodes(priorityQueue.peek(), "");
    }

    private static void buildHuffmanCodes(HuffmanNode root, String code) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                huffmanCodes.put(root.data, code);
            }

            buildHuffmanCodes(root.left, code + "0");
            buildHuffmanCodes(root.right, code + "1");
        }
    }

    public static void printHuffmanCodes() {
        System.out.println("Huffman Codes:");
        for (var entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int numCharacters = scanner.nextInt();

        char[] characters = new char[numCharacters];
        int[] frequencies = new int[numCharacters];

        System.out.println("Enter characters and their frequencies:");

        for (int i = 0; i < numCharacters; i++) {
            System.out.print("Enter character: ");
            characters[i] = scanner.next().charAt(0);

            System.out.print("Enter frequency: ");
            frequencies[i] = scanner.nextInt();
        }

        buildHuffmanTree(characters, frequencies);
        printHuffmanCodes();
    }
}
