package restaurant.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractController<T> {

	private FileInputStream fileInputStream;
	private ObjectInputStream objectInputStream;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;

	protected T loadReadIOFile(String directory) {

		T obj = null;

		try {
			fileInputStream = new FileInputStream(directory);
			objectInputStream = new ObjectInputStream(fileInputStream);

			obj = (T) objectInputStream.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				System.out.println("File failed to close successfully");
			}
		}

		return obj;
	}

	protected void writeSaveIOFile(String directory, T obj) {

		try {
			fileOutputStream = new FileOutputStream(directory);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null)
					fileOutputStream.close();
			} catch (IOException e) {
				System.out.println("File failed to close successfully");
			}
		}
	}
}
