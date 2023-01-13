package com.github.merlinths.codegolf.minify

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinifyTest {
    @Test
    fun `Empty class`() {
        val classDeclaration = """
            
            
            public class Main {
                
            }
            
            
        """

        assertEquals(
            expected = "public class Main{}",
            actual = classDeclaration.minify()
        )
    }

    @Test
    fun `Interface with main method`() {
        val classDeclaration = """
            private interface Example {
                public static void main(String[] args) {
                    System.out.println("Hello World!");
                }
            }
        """

        assertEquals(
            expected = """private interface Example{public static void main(String[]args){System.out.println("Hello World!");}}""",
            actual = classDeclaration.minify()
        )
    }

    @Test
    fun `Comma separated method call`() {
        val methodCall = """
            
            System  .   out .    
            println    (     "Have a good day!"   
                    )   
            ;
            
        """

        assertEquals(
            expected = """System.out.println("Have a good day!");""",
            actual = methodCall.minify()
        )
    }

    @Test
    fun `Arithmetical operations`() {
        val operation = """
            var result = ( x * Math . pow( i + 3 *  5 - 2) % 13 / 999999_999 )  ;
        """

        assertEquals(
            expected = "var result=(x*Math.pow(i+3*5-2)%13/999999_999);",
            actual = operation.minify()
        )
    }

    @Test
    fun `Logical operations`() {
        val operations = """
           final var result  =      ( 
                true  | false && ( 33 > 2) || a&b ^ c^d|e
                ) ;
        """

        assertEquals(
            expected = """final var result=(true|false&&(33>2)||a&b^c^d|e);""",
            actual = operations.minify()
        )
    }

    @Test
    fun `Lambda expressions`() {
        val lambda = """
            "My favorite text"
                . replace( "\s"  ,  match -> {
                    System   . out . println(  "Matches!" ) ;
                }
        """

        assertEquals(
            expected = """"My favorite text".replace("\s",match->{System.out.println("Matches!");}""",
            actual = lambda.minify()
        )
    }

    @Test
    fun `Escaped quotation marks`() {
        val quote = """
            var test = "  He said: \" Hello   world ! \"  ";
        """

        assertEquals(
            expected = """var test="  He said: \" Hello   world ! \"  ";""",
            actual = quote.minify()
        )
    }

    @Test
    fun `Quotation marks`() {
        val quote = """
            var test = "   " ;
            String anotherOne = "     " +  "  " ;
        """

        assertEquals(
            expected = """var test="   ";String anotherOne="     "+"  ";""",
            actual = quote.minify()
        )
    }

    @Test
    fun `Quotation mark in char declaration`() {
        val declaration = """ 
             char character    =   '"'    ;
        """

        assertEquals(
            expected = """char character='"';""",
            actual = declaration.minify()
        )
    }

    @Test
    fun `Brackets in String literals`() {
        val string = """
            val myString  = "  (   H e l l o   ,  W o r l d ! ) ";
        """

        assertEquals(
            expected = """val myString="  (   H e l l o   ,  W o r l d ! ) ";""",
            actual = string.minify()
        )
    }

    @Test
    fun `Ternary operator`() {
        val operation = """
            val result = (   83 < 9 )  ?   0      :   9   ;
        """

        assertEquals(
            expected = "val result=(83<9)?0:9;",
            actual = operation.minify()
        )
    }

    @Test
    fun `Unnecessary whitespace between keywords`() {
        val codeWithSpaces = """
            interface Code {
                public    static    void    main  (  String [] args ) {
                    /* Body */
                }
            }
        """

        assertEquals(
            expected = """interface Code{public static void main(String[]args){}}""",
            actual = codeWithSpaces.minify()
        )
    }

    @Nested
    @DisplayName("Elements to remove")
    inner class RemoveElementsTest {
        @Test
        fun `Package declaration`() {
            val codeWithPackage = """
                 package com.minify.test;
                 
                 interface Brainfuck {
                    public static void main(String[] args) {
                        // Body
                        System.out.print("Sample statement!");
                    }
                 }
            """

            assertEquals(
                expected = """interface Brainfuck{public static void main(String[]args){System.out.print("Sample statement!");}}""",
                actual = codeWithPackage.minify()
            )
        }

        @Test
        fun `Single line comment`() {
            val comment = """
            System   . out    
             . println(  "Hello"  );  // Hopefully removed...
             
             
             // Another one
             
        """

            assertEquals(
                expected = """System.out.println("Hello");""",
                actual = comment.minify()
            )
        }

        @Test
        fun `Multi line comment`() {
            val comment = """
            /*
                Some info! "
            */
            val onlyLine = 1;
        """

            assertEquals(
                expected = "val onlyLine=1;",
                actual = comment.minify()
            )
        }
    }
}