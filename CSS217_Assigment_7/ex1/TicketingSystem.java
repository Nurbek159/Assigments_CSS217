package asssigment_7;

interface SupportHandler {
    void handleRequest(SupportRequest request);
    void setNextHandler(SupportHandler nextHandler);
}

abstract class SupportRequest {
    private int id;
    private String description;
    private PriorityLevel priorityLevel;

    public SupportRequest(int id, String description, PriorityLevel priorityLevel) {
        this.id = id;
        this.description = description;
        this.priorityLevel = priorityLevel;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public PriorityLevel getPriorityLevel() {
        return priorityLevel;
    }
}

class HardwareRequest extends SupportRequest {
    public HardwareRequest(int id, String description, PriorityLevel priorityLevel) {
        super(id, description, priorityLevel);
    }
}

class SoftwareRequest extends SupportRequest {
    public SoftwareRequest(int id, String description, PriorityLevel priorityLevel) {
        super(id, description, priorityLevel);
    }
}

class NetworkRequest extends SupportRequest {
    public NetworkRequest(int id, String description, PriorityLevel priorityLevel) {
        super(id, description, priorityLevel);
    }
}

enum PriorityLevel {
    LOW, MEDIUM, HIGH
}

class HardwareHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportRequest request) {
        if (request instanceof HardwareRequest) {
            System.out.println("Hardware team is handling the request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for the request: " + request.getDescription());
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class SoftwareHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportRequest request) {
        if (request instanceof SoftwareRequest) {
            System.out.println("Software team is handling the request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for the request: " + request.getDescription());
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

class NetworkHandler implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void handleRequest(SupportRequest request) {
        if (request instanceof NetworkRequest) {
            System.out.println("Network team is handling the request: " + request.getDescription());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No handler found for the request: " + request.getDescription());
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

public class TicketingSystem {
    public static void main(String[] args) {
        HardwareHandler hardwareHandler = new HardwareHandler();
        SoftwareHandler softwareHandler = new SoftwareHandler();
        NetworkHandler networkHandler = new NetworkHandler();

        hardwareHandler.setNextHandler(softwareHandler);
        softwareHandler.setNextHandler(networkHandler);

        SupportRequest hardwareRequest = new HardwareRequest(1, "Hardware issue: Printer not working", PriorityLevel.HIGH);
        SupportRequest softwareRequest = new SoftwareRequest(2, "Software issue: Application crashing", PriorityLevel.MEDIUM);
        SupportRequest networkRequest = new NetworkRequest(3, "Network issue: Internet connection slow", PriorityLevel.LOW);
        SupportRequest unknownRequest = new SupportRequest(4, "Unknown issue: Need assistance", PriorityLevel.MEDIUM) {
        };

        hardwareHandler.handleRequest(hardwareRequest);
        hardwareHandler.handleRequest(softwareRequest);
        hardwareHandler.handleRequest(networkRequest);
        hardwareHandler.handleRequest(unknownRequest);
    }
}
