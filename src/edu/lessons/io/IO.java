package edu.lessons.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IO {
    public static void main(String[] args) {



    }

    public static void demoIOStream() {

        try (InputStream is = new FileInputStream("/home/vlad/Downloads/myJsonFile0.json");
             OutputStream os = new FileOutputStream("test.txt")) {

            byte[] buffer = new byte[2048];
            int r = is.read(buffer);

            while(r != -1){
                os.write(buffer, 0, r);
                r = is.read(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void demoReadWrite() {

        try (Reader r = new FileReader("Test.iml");
             Writer w = new FileWriter("test.txt", true)) {

            char[] buffer = new char[2048];
            int i = r.read(buffer);

            while(i != -1){
                // w.write(buffer, 0 , i);
                w.append(new String(buffer), 0, i);
                i = r.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void encodeDemo() {

        try (InputStream fis = new FileInputStream("test.txt");
             Reader r = new InputStreamReader(fis, "utf-8");
             BufferedReader br = new BufferedReader(r)) {

            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    ---------------NIO---------------

    public static void channel() {

        try (FileInputStream fis = new FileInputStream("Test.iml");
             FileOutputStream fos = new FileOutputStream("new.txt")) {

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            ByteBuffer inBb = ByteBuffer.allocate(2048);
            ByteBuffer outBb = ByteBuffer.allocate(2048);

            int r = inChannel.read(inBb);

            while(r != -1){
                inBb.flip();
                while(inBb.hasRemaining()){
                    byte get = inBb.get();
                    outBb.put(get);
                }
                outBb.flip();
                outChannel.write(outBb);
                inBb.clear();
                outBb.clear();
                r = inChannel.read(inBb);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void transferDemo() {

        try (FileInputStream is = new FileInputStream("Test.iml");
             FileOutputStream os = new FileOutputStream("newTransfer.txt")) {

            FileChannel inChannel = is.getChannel();
            FileChannel outChannel = os.getChannel();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
