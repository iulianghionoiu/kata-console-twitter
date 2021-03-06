/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.twitter.context.output;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class StorageOutputChannel implements OutputChannel {
    StringBuilder outputBuffer;

    public StorageOutputChannel() {
        outputBuffer = new StringBuilder();
    }

    public void reset() {
        outputBuffer.delete(0, outputBuffer.length());
    }

    @Override
    public void writeMessage(String message) {
        outputBuffer.append(message).append("\n");
    }

    public String getStoredOutput() {
        return outputBuffer.toString();
    }
}
