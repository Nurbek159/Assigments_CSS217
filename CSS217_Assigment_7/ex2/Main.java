package as2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        DocumentStorage documentStorage = new DocumentStorageImpl();
        DocumentManagementProxy proxy = new DocumentManagementProxy(documentStorage);

        proxy.authenticateUser("alice", "password123");


        Map<String, Object> metadata = new HashMap<>();
        metadata.put("id", 1);
        metadata.put("author", "alice");
        Document document = new DocumentImpl("This is a test document.", metadata);
        proxy.saveDocument(document);


        Document readDocument = proxy.getDocument("1");
        System.out.println(readDocument.getContent()); // Output: This is a test document.


        Document restrictedDocument = proxy.getDocument("2");
    }
}
