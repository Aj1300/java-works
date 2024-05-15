import java.net.*;
import java.io.*;

    public class UDPReceiver {
        public static void main(String[] args) {
            // Port number for receiving messages
            int port = 9876;
    
            try {
                DatagramSocket socket = new DatagramSocket(port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
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
                    // Create a buffer to store incoming data
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
                }
    
                // Close the socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
