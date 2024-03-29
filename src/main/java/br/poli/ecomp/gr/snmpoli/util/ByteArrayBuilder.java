package br.poli.ecomp.gr.snmpoli.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ByteArrayBuilder {
	
	private DataOutputStream dataOutputStream;
	private ByteArrayOutputStream byteArrayOutputStream;
	
	public ByteArrayBuilder() {
		byteArrayOutputStream = new ByteArrayOutputStream();
		dataOutputStream = new DataOutputStream(byteArrayOutputStream);	
	}
	
	public ByteArrayBuilder writeInt(int number) throws IOException {
		this.dataOutputStream.writeInt(number);
		return this;
	}
	
	public ByteArrayBuilder writeByte(byte number) throws IOException {
		this.dataOutputStream.writeByte(number);
		return this;
	}
	
	public ByteArrayBuilder writeChar(char chr) throws IOException {
		this.dataOutputStream.writeChar(chr);
		return this;
	}
	
	public ByteArrayBuilder writeBytes(byte[] bts) throws IOException {
		this.dataOutputStream.write(bts);
		return this;
	}
	
	public ByteArrayBuilder writeBytes(String bts) throws IOException {
		this.dataOutputStream.writeBytes(bts);
		return this;
	}
	
	public ByteArrayBuilder writeBytes(char[] bts) throws IOException {
		return writeBytes(new String(bts));
	}
	
	public ByteArrayBuilder writeInts(int[] ints) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(ints.length * 4);        
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        intBuffer.put(ints);

        byte[] array = byteBuffer.array();
		return writeBytes(array);
	}
	
	public byte[] getBytes() {
		return byteArrayOutputStream.toByteArray();
	}
	
}
