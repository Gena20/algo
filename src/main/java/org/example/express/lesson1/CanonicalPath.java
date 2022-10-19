package org.example.express.lesson1;

import java.util.*;

public class CanonicalPath {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var path = sc.nextLine();

        var pathParts = path.split("/", -1);

        var canonicalPathParts = new ArrayList<String>();
        for (var part : pathParts) {
            if (Objects.equals(part, ".") || part.isBlank()) {
                continue;
            }

            if (Objects.equals(part, "..")) {
                if (!canonicalPathParts.isEmpty()) {
                    canonicalPathParts.remove(canonicalPathParts.size() - 1);
                }

                continue;
            }

            canonicalPathParts.add(part);
        }

        var canonicalPath = "/" + String.join("/", canonicalPathParts);

        System.out.println(canonicalPath);
    }
}
