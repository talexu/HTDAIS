package com.talexu.htdais_demo_word2vec;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Word2Vec vec = new Word2Vec();
    	try {
			vec.loadModel("/Users/bjutales/Documents/Development/Resources/vectors.bin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	 System.out.println(vec.distance("男人"));
    	System.out.println(vec.analogy("中华民国", "中华人民共和国", "毛泽东"));
    	System.out.println(vec.distance(new String[]{"中华民国", "中华人民共和国", "毛泽东"}));
    	System.out.println(vec.distance("恐怖袭击"));
    	System.out.println(vec.distance("利比亚"));
    	System.out.println(vec.getWordVector("利比亚"));
    	System.err.println(vec.getWordVector("奥运会"));
    }
}
