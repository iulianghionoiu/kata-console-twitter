package ro.ghionoiu.twitter;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ro.ghionoiu.twitter.channels.InputChannel;
import ro.ghionoiu.twitter.channels.input.ArrayBasedInputChannel;
import ro.ghionoiu.twitter.channels.output.StorageOutputChannel;

@RunWith(ConcordionRunner.class)
public class ConsoleTwitterFixture {
    private Engine engine;
    private StorageOutputChannel outputChannel;
    
    /**
     * Resets all the variables to the empty state
     */
    public void reset() {
        outputChannel = new StorageOutputChannel();
        engine = new Engine(outputChannel);
    }
    
    /**
     * Simulate a console input and return output
     * @param time
     * @param command
     * @return 
     */
    public String submitCommand(String time, String command) {
        InputChannel inputChannel = new ArrayBasedInputChannel(command);
        outputChannel.reset();
        Server server = new Server(inputChannel, engine);
        
        //Start server
        server.start();
        
        return outputChannel.getStoredOutput();
    }
}
