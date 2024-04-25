package as2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Document interface
interface Document {
    String getContent();
    void setContent(String content);
    Map<String, Object> getMetadata();
    void setMetadata(Map<String, Object> metadata);
}

class DocumentImpl implements Document {
    private String content;
    private Map<String, Object> metadata;

    public DocumentImpl(String content, Map<String, Object> metadata) {
        this.content = content;
        this.metadata = metadata;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}


interface DocumentStorage {
    Document getDocument(String id);
    void saveDocument(Document document);
}

class DocumentStorageImpl implements DocumentStorage {
    private Map<String, Document> documents = new HashMap<>();

    @Override
    public Document getDocument(String id) {
        return documents.get(id);
    }

    @Override
    public void saveDocument(Document document) {
        documents.put(document.getMetadata().get("id").toString(), document);
    }
}

class DocumentManagementProxy implements DocumentStorage {
    private DocumentStorage documentStorage;
    private Map<String, User> userSessions = new HashMap<>();

    public DocumentManagementProxy(DocumentStorage documentStorage) {
        this.documentStorage = documentStorage;
    }

    public void authenticateUser(String username, String password) {
        // Authenticate user and create a new session
        User user = new User(username);
        userSessions.put(user.getSessionId(), user);
    }

    private boolean hasPermission(String sessionId, String operation, Document document) {
        // Check user's permissions based on the operation and document metadata
        User user = userSessions.get(sessionId);
        return user.hasPermission(operation, document.getMetadata());
    }

    private Document filterDocument(String sessionId, Document document) {

        User user = userSessions.get(sessionId);
        Map<String, Object> filteredMetadata = new HashMap<>(document.getMetadata());
        String filteredContent = document.getContent();


        return new DocumentImpl(filteredContent, filteredMetadata);
    }

    private void logUserActivity(String sessionId, String operation, Document document) {
        User user = userSessions.get(sessionId);
        System.out.printf("User %s performed %s operation on document %s%n", user.getUsername(), operation, document.getMetadata().get("id"));
    }


    public List<Document> searchDocuments(String sessionId, String query, Map<String, Object> filters) {

        List<Document> matchingDocuments = new ArrayList<>();


        return matchingDocuments;
    }

    @Override
    public Document getDocument(String id) {
        String sessionId = userSessions.keySet().iterator().next(); // Assuming a single active session
        Document document = documentStorage.getDocument(id);
        if (document == null) {
            // Handle the case where the requested document does not exist
            System.out.println("Document with ID " + id + " does not exist.");
            return null;
        }
        if (hasPermission(sessionId, "read", document)) {
            Document filteredDocument = filterDocument(sessionId, document);
            logUserActivity(sessionId, "read", filteredDocument);
            return filteredDocument;
        } else {
            throw new SecurityException("Access denied!");
        }
    }

    @Override
    public void saveDocument(Document document) {
        String sessionId = userSessions.keySet().iterator().next(); // Assuming a single active session
        if (hasPermission(sessionId, "write", document)) {
            documentStorage.saveDocument(document);
            logUserActivity(sessionId, "write", document);
        } else {
            throw new SecurityException("Access denied!");
        }
    }
}

class User {
    private String username;
    private String sessionId;

    public User(String username) {
        this.username = username;
        this.sessionId = generateSessionId();
    }

    public String getUsername() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }

    private String generateSessionId() {
        // Generate a unique session ID
        return java.util.UUID.randomUUID().toString();
    }

    public boolean hasPermission(String operation, Map<String, Object> documentMetadata) {

        return true;
    }
}
