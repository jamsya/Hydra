package de.datasecs.hydra.example.shared.serialization;

import de.datasecs.hydra.shared.protocol.packets.Packet;
import de.datasecs.hydra.shared.protocol.packets.PacketId;
import io.netty.buffer.ByteBuf;

import java.util.Arrays;

/**
 * Created with love by DataSecs on 12.02.18
 */
@PacketId(1)
public class ExampleSerializationPacket extends Packet {

    private CustomClass customClass;

    private CustomClass[] customClasses;

    public ExampleSerializationPacket() {}

    public ExampleSerializationPacket(CustomClass customClass) {
        this.customClass = customClass;
    }

    @Override
    public void read(ByteBuf byteBuf) {
        customClass = readCustomObject(byteBuf);
        customClasses = readCustomClassArray(byteBuf);
    }

    @Override
    public void write(ByteBuf byteBuf) {
        /* The string 'pathOfCustomClassAtReceiver' is used to determine what the package name of the custom class
         * is, at the server side. As the package names from client and server very likely differ (actually should differ),
         * there is this string to determine the package where ALL the classes that are related to each other and have to
         * be serialized are inside. Therefore it's necessary to put all related classes that are supposed to be serialized
         * together in a package. This is the only (big) drawback.
         */
        writeCustomObject(byteBuf, customClass, "de.datasecs.hydra.example.shared.serialization");

        // This method allows the user to send an array of custom classes. This method also needs the 'pathOfCustomClassAtReceiver'
        writeCustomClassArray(byteBuf, new CustomClass[]{customClass, customClass}, "de.datasecs.hydra.example.shared.serialization");
    }

    // Auto-generated toString method by IntelliJ for example purposes
    @Override
    public String toString() {
        return "ExampleSerializationPacket{" +
                "customClass=" + customClass +
                "customClasses=" + Arrays.toString(customClasses) +
                '}';
    }
}