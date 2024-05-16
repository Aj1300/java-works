import java.io.*;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) {
        // Port number for sending messages
        int port = 9876;

        try {
            DatagramSocket socket = new DatagramSocket();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                byte[] buffer = new byte[1024];
    
                // Create a UDP packet to receive data
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Receive the packet
                socket.receive(packet);

                // Convert the received data to string and print
                String receivedMessage = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + receivedMessage);

                // Check if the received message is "exit"
                if (receivedMessage.equals("exit")) {
                    break;
                }



                // Read user input
                String message = reader.readLine();

                // Check if the user wants to exit
                if (message.equals("exit")) {
                    break;
                }

                // Convert the message to bytes
                byte[] buff = message.getBytes();

                // Get the IP address of the receiver
                InetAddress receiverAddress = InetAddress.getLocalHost();

                // Create a UDP packet with the message, receiver address, and port
                DatagramPacket packe = new DatagramPacket(buff, buff.length, receiverAddress, port);

                // Send the packet
                socket.send(packe);







            }
            
            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
