package project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Post {
    private String content;
    private User author;
    private LocalDateTime timestamp;

    public Post(String content, User author, LocalDateTime timestamp) {
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }


}

class User {
    private String name;
    private String email;
    private String password;
    private List<Post> newsFeed = new ArrayList<>();
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public void addPostToNewsFeed(Post post) {
        newsFeed.add(post);
    }

    public List<User> getFollowers() {
        return followers;
    }

}

interface Observer {
    void update(Post newPost);
}

class NewsFeedObserver implements Observer {
    private User user;

    public NewsFeedObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(Post newPost) {
        user.addPostToNewsFeed(newPost);
    }
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Post newPost);
}

class PostSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Post newPost) {
        for (Observer observer : observers) {
            observer.update(newPost);
        }
    }
}

class SocialMediaFacade {
    private UserService userService;
    private PostService postService;
    private NotificationService notificationService;

    public SocialMediaFacade() {
        userService = new UserService();
        postService = new PostService();
        notificationService = new NotificationService();
    }

    public UserService getUserService() {
        return userService;
    }

    public void createPost(User author, String content) {
        Post newPost = postService.createPost(author, content);
        notificationService.notifyFollowers(author, newPost);
    }

}

// Service classes
class UserService {
    private Map<String, User> users = new HashMap<>();

    public User createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        users.put(email, newUser);
        return newUser;
    }

    public User getUserByEmail(String email) {
        return users.get(email);
    }

}

class PostService {
    private PostSubject postSubject;

    public PostService() {
        postSubject = new PostSubject();
    }

    public Post createPost(User author, String content) {
        Post newPost = new Post(content, author, LocalDateTime.now());
        postSubject.notifyObservers(newPost);
        return newPost;
    }
}

class NotificationService {
    public void notifyFollowers(User author, Post newPost) {
        for (User follower : author.getFollowers()) {
        }
    }
}

interface PostFactory {
    Post createPost(String content, User author);
}

class TextPostFactory implements PostFactory {
    @Override
    public Post createPost(String content, User author) {
        return new TextPost(content, author, LocalDateTime.now());
    }
}

class ImagePostFactory implements PostFactory {
    @Override
    public Post createPost(String content, User author) {
        return new ImagePost(content, author, LocalDateTime.now());
    }
}

class TextPost extends Post {
    public TextPost(String content, User author, LocalDateTime timestamp) {
        super(content, author, timestamp);
    }
}

class ImagePost extends Post {
    private String imageUrl;

    public ImagePost(String content, User author, LocalDateTime timestamp) {
        super(content, author, timestamp);
    }

}

class UserServiceApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
    }
}

class PostServiceApplication {
    public static void main(String[] args) {
        PostService postService = new PostService();
    }
}

class NotificationServiceApplication {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        // Start the NotificationService microservice
    }
}


public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMediaFacade facade = new SocialMediaFacade();

        User user1 = facade.getUserService().createUser("John", "john@email.com", "password");
        User user2 = facade.getUserService().createUser("Jane", "jane@email.com", "password");

        NewsFeedObserver observer1 = new NewsFeedObserver(user1);
        NewsFeedObserver observer2 = new NewsFeedObserver(user2);

        facade.createPost(user1, "Hello, world!");
        facade.createPost(user2, "Having a great day!");

        // Create a text post
        PostFactory textPostFactory = new TextPostFactory();
        Post textPost = textPostFactory.createPost("This is a text post.", user1);

        // Create an image post
        PostFactory imagePostFactory = new ImagePostFactory();
        Post imagePost = imagePostFactory.createPost("This is an image post.", user2);
    }
}