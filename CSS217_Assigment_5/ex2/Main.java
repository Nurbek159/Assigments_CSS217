package ex2;

import java.util.HashMap;
import java.util.Map;

class Data {
    private String type;
    private Object content;

    public Data(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

abstract class DataProcessor {
    public abstract void process(Data data);
}

class TextDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        // Process text data
        System.out.println("Processing text data: " + data.getContent());
    }
}

class AudioDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        // Process audio data
        System.out.println("Processing audio data: " + data.getContent());
    }
}

class VideoDataProcessor extends DataProcessor {
    @Override
    public void process(Data data) {
        // Process video data
        System.out.println("Processing video data: " + data.getContent());
    }
}

class TextContent {

}

class AudioContent {
    // Implementation
}

class VideoContent {
    // Implementation
}

class DataProcessorCreator {
    private DataProcessor processor;

    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    }

    public void processData(Data data) {
        if (processor == null) {
            throw new IllegalStateException("Processor not set");
        }
        processor.process(data);
    }
}


public class Main {
    public static void main(String[] args) {
        DataProcessorCreator processorCreator = new DataProcessorCreator();

        processorCreator.setProcessor(new TextDataProcessor());
        Data textData = new Data("text", new TextContent());
        processorCreator.processData(textData);

        processorCreator.setProcessor(new AudioDataProcessor());
        Data audioData = new Data("audio", new AudioContent());
        processorCreator.processData(audioData);

        processorCreator.setProcessor(new VideoDataProcessor());
        Data videoData = new Data("video", new VideoContent());
        processorCreator.processData(videoData);
    }
}
