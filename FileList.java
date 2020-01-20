//Julianna Ngo's FileList.java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class FileList<E extends Number> extends FileContainer implements List<E>{

	/**
	 * The File Object used to create/delete actual files and store elements
	 */
	private File current;
	
	/**
	 * The size of the FileList (the number of elements it contains)
	 */
	private int size;
	
	/**
	 * Constructs an empty FileList
	 */
	public FileList(){
		this(Long.toString(System.currentTimeMillis()));
	}
	
	/**
	 * Constructs a new FileList. If a file already exists with the same name as fileName
	 * the FileList will read and write to the existing file. Otherwise, an empty FileList is
	 * constructed
	 * 
	 * @param fileName the name of the file
	 * @throws IOException if the file could not be created
	 */
	public FileList(String fileName) {
		File tempF = new File(fileName);
		if (tempF.exists()) {
			current = tempF;
			size = this.sizeHelper();
		}
		else {
			try {
				tempF.createNewFile();
				Thread.sleep(1);
				current = tempF;
				size = 0;
			} catch (IOException e) {
				System.out.println("Error: Couln't create new file");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * A helper method to throw an exception for methods unsupported by this implementation 
	 * of the List interface
	 * 
	 * @throws UnsupportedOperationException
	 */
	private Exception someUnneededMethod() {
		 throw new UnsupportedOperationException();
	} 

	
	/**
	 * Appends the specified element to the end of this list
	 * 
	 * @param e element to be appended to this list
	 * @throws NullPointerException if e is null
	 * @throws ClassCastException if e's class does not extend number
	 * @returns true 
	 */
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		else if (!((e.getClass() == Float.class) || (e.getClass() == Integer.class) || (e.getClass() == Short.class) || (e.getClass() == Byte.class) || (e.getClass() == Double.class) || (e.getClass() == Long.class))) {
			throw new ClassCastException();
		}
		else {
			try {
				if (current.exists()) {
					FileWriter writerF = new FileWriter(current, true);
					writerF.write(e.getClass().getSimpleName().charAt(0)+ e.toString() + "\n");
					writerF.close();
				}
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		size++;
		return true;
	}
	

	/**
	 * Adds an element to the specified index of the FileList
	 * 
	 * @param index the index where the element will be added
	 * @param element the element being added
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index > size)
	 */
	public void add(int index, E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		else if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		boolean added = false;
		File tempFile = new File("addIndexTemp.txt");
		try {
			Thread.sleep(1);
			tempFile.createNewFile();
			Scanner scanner = new Scanner(this.current);
			FileWriter writer = new FileWriter(tempFile, false);
			for (int i = 0; i <= size; i++) {
				if (i == index && added == false) {
					added = true;
					size++;
					writer.write(element.getClass().getSimpleName().charAt(0)+element.toString()+"\n");
				}
				else {
					if (scanner.hasNextLine()) {
						String s = scanner.nextLine();
						writer.write(s + "\n");
					}
				}
			}
			writer.flush();
			writer.close();
			scanner.close();
			
			FileWriter nWriter = new FileWriter(current, false);
			Scanner nScanner = new Scanner(tempFile);
			
			while(nScanner.hasNextLine()) {
				nWriter.write(nScanner.nextLine() + "\n");
			}
			nWriter.flush();
			nWriter.close();
			nScanner.close();
			
			tempFile.delete();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Clears the FileList
	 * 
	 * @throws IOException
	 */
	public void clear() {
		try {
			current.delete();
			current.createNewFile();
			this.size = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes an element from the specified index
	 * 
	 * @param index the index where an element will be removed
	 * @throws IndexOutOfBoundsException if the specified index is out of range (index < 0 || index >= size)
	 * @returns the element previously at the specified index
	 */
	public E remove (int index) {
		if ((index < 0) || (index >= size)) {
			throw new IndexOutOfBoundsException(String.format("Index:%d Size:%d",index,size()));
		}
		E removedElement = null;
		File tempFile = new File("removeTemp.txt");
		boolean removed = false;
		try {
			Thread.sleep(1);
			tempFile.createNewFile();
			Scanner scanner = new Scanner(this.current);
			FileWriter writer = new FileWriter(tempFile, false);
			for (int i = 0; scanner.hasNextLine(); i++) {
				if (i == index && removed == false) {
					removed = true;
					String line = scanner.nextLine();
					if (line.charAt(0) == 'F') {
						Float f = Float.parseFloat(line.substring(1));
						removedElement = (E) f;
					}
					else if(line.charAt(0) == 'I') {
						Integer inte = Integer.parseInt(line.substring(1));
						removedElement = (E) inte;
					}
					else if (line.charAt(0) == 'B') {
						Byte by = Byte.parseByte(line.substring(1));
						removedElement = (E) by;
					}
					else if (line.charAt(0)=='L') {
						Long noodle = Long.parseLong(line.substring(1));
						removedElement = (E) noodle;
					}
					else if (line.charAt(0) == 'D') {
						Double twin = Double.parseDouble(line.substring(1));
						removedElement = (E) twin;
					}
					else {
						Short tiny = Short.parseShort(line.substring(1));
						removedElement = (E) tiny;
					}
				}
				else {
					String s = scanner.nextLine();
					writer.write(s + "\n");
				}
			}
			writer.flush();
			writer.close();
			scanner.close();
			
			FileWriter nWriter = new FileWriter(current, false);
			Scanner nScanner = new Scanner(tempFile);
			
			while(nScanner.hasNextLine()) {
				nWriter.write(nScanner.nextLine() + "\n");
			}
			nWriter.flush();
			nWriter.close();
			nScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tempFile.delete();
		size--;
		return removedElement;
	}
	
	
	/**
	 * Removes the first instance of the specified object and returns true. 
	 * If the list does not contain the object, then returns false.
	 * 
	 * @param o the object to be removed
	 * @throws NullPointerException if specified object is null
	 * @throws ClassCastException if the class of o does not extend class Number
	 * @return true if object is removed and false otherwise
	 */
	@Override
	public boolean remove(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (!((o.getClass() == Float.class) || (o.getClass() == Integer.class) || (o.getClass() == Short.class) || (o.getClass() == Byte.class) || (o.getClass() == Double.class) || (o.getClass() == Long.class))) {
			throw new ClassCastException();
		}
		File tempFile = new File("removeOTemp.txt");
		boolean removed = false;
		Scanner scanner;
		try {
			FileWriter wtr = new FileWriter(tempFile);
			scanner = new Scanner(current);
			while(scanner.hasNextLine()) {
				Object cE = null;
				String s = scanner.nextLine();
				if (s.charAt(0) == 'F') {
					cE = Float.parseFloat(s.substring(1));
				}
				else if(s.charAt(0) == 'I') {
					cE = Integer.parseInt(s.substring(1));
				}
				else if (s.charAt(0) == 'B') {
					cE = Byte.parseByte(s.substring(1));
				}
				else if (s.charAt(0)=='L') {
					cE = Long.parseLong(s.substring(1));
				}
				else if (s.charAt(0) == 'D') {
					cE = Double.parseDouble (s.substring(1));
				}
				else {
					cE = Short.parseShort(s.substring(1));
				}
				
				if (cE.equals(o) && !removed) {
					removed = true;
					size--;
				}
				else {
					wtr.write(s + "\n");
				}
			}
			wtr.flush();
			wtr.close();
			scanner.close();
			
			FileWriter nWriter = new FileWriter(current, false);
			Scanner nScanner = new Scanner(tempFile);
			
			while(nScanner.hasNextLine()) {
				nWriter.write(nScanner.nextLine() + "\n");
			}
			nWriter.flush();
			nWriter.close();
			nScanner.close();
			
			tempFile.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return removed;
	}

	/**
	 * Returns a string containing the elements of the list enclosed within square brackets and separated by commas.
	 * 
	 * @return a String representation of FileList
	 */
	public String toString() {
		String s = "";
		s += "[";
		try {  
			if (current.exists()) {
			Scanner scanner = new Scanner(current);
			while(scanner.hasNextLine()) {
				String k = scanner.nextLine().substring(1);
				if (!scanner.hasNextLine()) {
					s += k;
				}
				else {
					s += k+", ";
				}
			}
				scanner.close();
			}
		} catch (IOException e) {
			System.out.print("File for Scanner not Found");
		}
		s += "]";
		return s;
	}
	
	/**
	 * Scans through the list and returns the number of elements.
	 * 
	 * @return the size of the list
	 */
	private int sizeHelper() {
		Scanner scanner;
		int i = 0;
		try {
			scanner = new Scanner(current);
			while(scanner.hasNextLine()) {
				scanner.nextLine();
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * Returns the size of the list
	 * 
	 * @return number of elements in list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Retrieves the file name used to store elements
	 * 
	 * @return String fileName
	 */
	@Override
	public String getFileName() {
		return current.getName();
	}

	/**
	 * Retrieves the file size in bytes
	 * 
	 * @return long file length
	 */
	@Override
	public long getFileSize() {
		return current.length();
	}

	
	//////////////////////////////////////////////////
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		someUnneededMethod();
		return null;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Number cE = null;
		Scanner scanner;
		try {
			scanner = new Scanner(current);
			String s = scanner.nextLine();
			if (s.charAt(0) == 'F') {
				cE = Float.parseFloat(s.substring(1));
			}
			else if(s.charAt(0) == 'I') {
				cE = Integer.parseInt(s.substring(1));
			}
			else if (s.charAt(0) == 'B') {
				cE = Byte.parseByte(s.substring(1));
			}
			else if (s.charAt(0)=='L') {
				cE = Long.parseLong(s.substring(1));
			}
			else if (s.charAt(0) == 'D') {
				cE = Double.parseDouble (s.substring(1));
			}
			else {
				cE = Short.parseShort(s.substring(1));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (E) cE;
	}

}


