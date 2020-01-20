//Tester for FileList by Julianna Ngo
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class MyTester {

	@Test(expected = NullPointerException.class)
	public void testAddNull() {
			FileList<Number> fl1 = new FileList<>();
			fl1.add(null);
	}
	
	@Test
	public void testAddVarious() {
			FileList<Number> fl2 = new FileList<>();
			fl2.add(-1L);
			fl2.add((int)2);
			fl2.add(-6e0);
			fl2.add((short)4.0);
			fl2.add(5F);
			fl2.add((byte)-6.000);
			
			ArrayList<Number> al2 = new ArrayList<>();
			al2.add(-1L);
			al2.add((int)2);
			al2.add(-6e0);
			al2.add((short)4.0);
			al2.add(5F);
			al2.add((byte)-6.000);
			
			assertEquals("Not correctly added, or toString is wrong",al2.toString(), fl2.toString());
	}
	
	@Test
	public void testAddTrue() {
			FileList<Number> fl2 = new FileList<>();
			boolean result = fl2.add(1L);
			
			assertEquals("Did not return true", true, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddIndexNull() {
			FileList<Number> fl3 = new FileList<>();
			fl3.add(0, null);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIndexIOBENeg1() {
			FileList<Number> fl3 = new FileList<>();
			fl3.add(-1, 123L);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddIndexIOBEPos1() {
			FileList<Number> fl3 = new FileList<>();
			fl3.add(1, 123L);
	}

	public void testAddIndexBegin() {
		FileList<Number> fl3 = new FileList<>();
		fl3.add(1);
		fl3.add(2);
		fl3.add(3);
		fl3.add(0, 123L);
		ArrayList<Number> al3 = new ArrayList<>();
		al3.add(1);
		al3.add(2);
		al3.add(3);
		al3.add(0, 123L);
		
		assertEquals("did not add at beginning correctly", al3.toString(), fl3.toString());
}
	@Test
	public void testAddIndexMid() {
		FileList<Number> fl2 = new FileList<>();
		fl2.add(0, 1L);
		fl2.add(1, (int)2);
		fl2.add(2, 6e0);
		fl2.add(3, (short)4.0);
		fl2.add(1, 5F);
		fl2.add(2, (byte)6.000);
		
		FileList<Number> al2 = new FileList<>();
		al2.add(0, 1L);
		al2.add(1, (int)2);
		al2.add(2, 6e0);
		al2.add(3, (short)4.0);
		al2.add(1, 5F);
		al2.add(2, (byte)6.000);
		
		assertEquals("did add in mid correctly", al2.toString(), fl2.toString());
	}
	
	@Test
	public void testAddIndexEnd() {
		FileList<Number> fl3 = new FileList<>();
		fl3.add(1);
		fl3.add(2);
		fl3.add(3);
		fl3.add(3, 123L);
		
		ArrayList<Number> al3 = new ArrayList<>();
		al3.add(1);
		al3.add(2);
		al3.add(3);
		al3.add(3, 123L);
		
		assertEquals("did not add at end correctly", al3.toString(), fl3.toString());
	}
	
	@Test
	public void testClear() {
		FileList<Number> fl4 = new FileList<>();
		fl4.add(1);
		fl4.add(2);
		fl4.add(3);
		fl4.add(3, 123L);
		
		ArrayList<Number> al3 = new ArrayList<>();
		al3.add(1);
		al3.add(2);
		al3.add(3);
		al3.add(3, 123L);
		
		fl4.clear();
		al3.clear();
		
		assertEquals("did not clear correctly", al3.toString(), fl4.toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRmvNeg() {
			FileList<Number> fl5 = new FileList<>();
			fl5.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRmvBig() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1);
			fl5.add(2);
			fl5.remove(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRmvSize() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1);
			fl5.add(2);
			fl5.remove(2);
	}
	
	@Test
	public void testRmv0() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1);
			fl5.remove(0);
			
			ArrayList<Number> al5 = new ArrayList<>();
			al5.add(1);
			al5.remove(0);
			
			assertEquals("Did not remove at 0 correctly", al5.toString(), fl5.toString());
	}
	
	@Test
	public void testRmvElement() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1L);
			fl5.add((short)4509);
			fl5.add(-12e8);

			Number removedFL = fl5.remove(2);
			
			ArrayList<Number> al5 = new ArrayList<>();
			al5.add(1L);
			al5.add((short)4509);
			al5.add(-12e8);
			
			Number removedAL = al5.remove(2);
			
			assertEquals("Did return element correctly", removedAL, removedFL);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRmvObjNull() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1L);
			fl5.remove(null);
	}
	
	@Test
	public void testRmvObjList() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1L);
			fl5.add(1L);
			fl5.add(348F);
			fl5.add(1L);
			fl5.remove(1L);
			
			ArrayList<Number> al5 = new ArrayList<>();
			al5.add(1L);
			al5.add(1L);
			al5.add(348F);
			al5.add(1L);
			al5.remove(1L);
			
			assertEquals("did not remove element correctly", al5.toString(), fl5.toString());
	}
	
	@Test
	public void testRmvObjTrue() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1L);
			fl5.add(1L);
			fl5.add(348F);
			fl5.add(1L);
			boolean result = fl5.remove(1L);
			
			assertEquals("did not return true", true, result);
	}
	
	@Test
	public void testRmvObjFalse() {
			FileList<Number> fl5 = new FileList<>();
			fl5.add(1L);
			fl5.add(1L);
			fl5.add(348F);
			fl5.add(1L);
			boolean result = fl5.remove(6e0);
			
			assertEquals("did not return false", false, result);
	}
	
	@Test
	public void testFileSize() {
			FileList<Number> fl6 = new FileList<>();
			fl6.add(1L);
			fl6.add(1L);
			fl6.add(348F);
			fl6.add(1L);
			
			FileList<Number> fl7 = new FileList<>();
			fl7.add(1L);
			fl7.add(1L);
			fl7.add(348F);
			fl7.add(1L);
			
			assertEquals("did not correct size in bytes", fl6.getFileSize(), fl7.getFileSize());
	}
	

	@Test
	public void testFileName() {
			FileList<Number> fl6 = new FileList<>("nameGetTest.txt");
			assertEquals("did not correct size in bytes", "nameGetTest.txt", fl6.getFileName());
	}
	
	//////--------------------SIZE TESTS------------------------------------------

	@Test
	public void testAdd1Size() {
		FileList<Number> fl2 = new FileList<>();
		fl2.add(1L);
		fl2.add((int)2);
		fl2.add(6e0);
		fl2.add((short)4.0);
		fl2.add(5F);
		fl2.add((byte)6.000);
		
		assertEquals("did no return correct Size from add(obj)", 6, fl2.size());
	}
	
	@Test
	public void testAdd2Size() {
		FileList<Number> fl2 = new FileList<>();
		fl2.add(0, 1L);
		fl2.add(1, (int)2);
		fl2.add(2, 6e0);
		fl2.add(3, (short)4.0);
		fl2.add(1, 5F);
		fl2.add(2, (byte)6.000);
		
		assertEquals("did no return correct Size from add(index)", 6, fl2.size());
	}
	
	@Test
	public void testRmv1Size() {
		FileList<Number> fl2 = new FileList<>();
		fl2.add(1L);
		fl2.add((int)2);
		fl2.add(6e0);
		fl2.remove(2);
		
		assertEquals("did no return correct Size from add(obj)", 2, fl2.size());
	}
	
	@Test
	public void testRmv2Size() {
		FileList<Number> fl2 = new FileList<>();
		fl2.add(0, 1L);
		fl2.add(1, (int)2);
		fl2.add(2, 6e0);
		fl2.add(3, (short)4.0);
		fl2.remove(1L);
		fl2.remove(6e0);
		fl2.remove(123F);
		
		assertEquals("did no return correct Size from add(index)", 2, fl2.size());
	}
}
