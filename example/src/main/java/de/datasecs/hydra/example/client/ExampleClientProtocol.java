package de.datasecs.hydra.example.client;

import de.datasecs.hydra.example.shared.ExamplePacket;
import de.datasecs.hydra.example.shared.serialization.ExampleSerializationPacket;
import de.datasecs.hydra.shared.protocol.impl.HydraProtocol;

/**
 * Created with love by DataSecs on 11.04.18
 */
public class ExampleClientProtocol extends HydraProtocol {

    public ExampleClientProtocol() {
        // Register your packets and listener. This is a very important step! Otherwise Hydra can't work with them!
        registerPacket(ExamplePacket.class);
        registerPacket(ExampleSerializationPacket.class);
        registerListener(new ExampleClientPacketListener());
    }
}
