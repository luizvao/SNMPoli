package br.poli.ecomp.gr.snmpoli.network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.poli.ecomp.gr.snmpoli.pojo.SNMPMessage;

public class RequestManager {

	private String hostname;
	private int port;
	private Socket socket;

	public RequestManager(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}

	public void connect() throws UnknownHostException, IOException {
		InetAddress address = InetAddress.getByName(hostname);
		socket = new Socket(address, port);
	}

	public void send(SNMPMessage message) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(
				socket.getOutputStream());
		OutputStreamWriter osw = new OutputStreamWriter(bos);
		osw.write(new String(message.encode()));
		osw.flush();
	}

	public String getResponse() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(
				socket.getInputStream());
		InputStreamReader isr = new InputStreamReader(bis);

		StringBuffer instr = new StringBuffer();
		int c;
		while ((c = isr.read()) != 13) {
			instr.append((char) c);
		}
		return instr.toString();
	}

	public void close() throws IOException {
		socket.close();
	}
}
