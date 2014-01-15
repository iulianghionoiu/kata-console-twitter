/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.twitter;

import ro.ghionoiu.twitter.channels.OutputChannel;
import ro.ghionoiu.twitter.channels.output.SystemConsoleOutput;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class Engine {
    private OutputChannel outputChannel;

    //~~~~~~~ Construct
    
    protected Engine(OutputChannel outputChannel) {
        this.outputChannel = outputChannel;
    }
    
    public Engine() {
        outputChannel = new SystemConsoleOutput();
    }
    
    //~~~~~~~ Run
    
    public void processCommand(String command) {
        outputChannel.writeMessage(command);
    }
}