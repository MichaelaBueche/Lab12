package lab12;

import java.util.*;
import java.io.*;

public class BSTReader {

	private Scanner reader=null;
	private File input=null;
	private BinarySearchTree<StudentGPA> students=new BinarySearchTree<StudentGPA>();
	private TreeIterator<StudentGPA> tempStudents=new TreeIterator<StudentGPA>(students);
	public BSTReader() {
		input=new File("students.in");
		try {
			reader=new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(reader.hasNextLine()) {//read in from file
			if(reader.nextLine().contains("BOSS"))//if graduate student, put in binary tree as new graduate student object
				students.insert(new GraduateStudentGPA(reader.nextInt(),reader.next(),reader.nextInt(),reader.next()));
			else//if student, put in binary tree as new student object
				students.insert(new StudentGPA(reader.nextInt(),reader.next(),reader.nextInt()));
		}
		tempStudents.printInorder();//print out students/graduate students in order sorted by GPA
		reader.close();
	}

	public static void main(String[] args) {
		new BSTReader();
	}

}
