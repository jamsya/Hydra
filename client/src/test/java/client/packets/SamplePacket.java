package client.packets;

import de.datasecs.hydra.shared.protocol.packets.Packet;
import de.datasecs.hydra.shared.protocol.packets.PacketId;

import java.util.Arrays;

/**
 * Created with love by DataSecs on 03.11.2017.
 */
/* This is a simple example for a packet class.
 * Just the empty, public constructor and the read, write methods are obligatory.
 * The rest of the class is up to you.
 * The PacketId annotation is used to internally handle the variety of packets. The default
 * value for it is 0. Each packet is supposed to have a different id, the system of assignment is up to the user.
 */
@PacketId(0)
public class SamplePacket extends Packet {

    private Object sampleObject;

    private String[] sampleStringArray;

    public SamplePacket() {
        // Empty constructor is always necessary!
    }

    // This constructor is not obligatory! Just the empty one.
    public SamplePacket(Object sampleObject, String[] sampleStringArray) {
        this.sampleObject = sampleObject;
        this.sampleStringArray = sampleStringArray;
    }

    @Override
    public void read() {
        sampleObject = readObject();
        sampleStringArray = readArray();
    }

    @Override
    public void write() {
        writeObject(sampleObject);
        writeArray(sampleStringArray);
    }

    // Auto-generated toString method by IntelliJ for example purposes
    @Override
    public String toString() {
        return "SamplePacket{" +
                "sampleObject=" + sampleObject +
                ", sampleStringArray=" + Arrays.toString(sampleStringArray) +
                '}';
    }
}