
//Завдання 3
//
//Використовуючи IntelliJ IDEA, створіть клас ReversedArray.
// Створити метод myReverse(int [] array), який приймає як аргумент масив цілочислових елементів
// і повертає інвертований масив (елементи масиву у зворотному порядку).
// Створити метод int [] subArray (int [] array, int index, int count).
// Метод повертає частину отриманого як аргумент масиву, починаючи з позиції,
// яка зазначена в аргументі index, розмірністю, що відповідає значенню аргументу count.
// Якщо аргумент count містить значення більше, ніж кількість елементів,
// що входять до частини вихідного масиву (від зазначеного індексу index до індексу останнього елемента),
// то під час формування нового масиву розмірністю в count,
// заповніть одиницями ті елементи, які не були скопійовані з вихідного масиву.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scInput = new Scanner(System.in);

        int arrayCount;
        do{
            System.out.print("Введіть розмір масива: ");
            arrayCount = scInput.nextInt();
            if(arrayCount<=0) System.out.println("Розмір масива не може бути менше або дорівнювати 0.");
            else break;

        }while(true);

        int[] arrayNumbers = CreateArray(arrayCount);
        PrintArray(arrayNumbers, false);

        int[] reverseArrayNumbers = CreateReverseArray(arrayNumbers);
        PrintArray(reverseArrayNumbers, true);

        int[] subArray = SubArray (arrayNumbers, scInput);
        PrintArray(subArray, false);
    }

    static void PrintArray(int[] arrayNumbers, boolean isRevers){
        int clock = 10;
        System.out.println("Масив " + (isRevers?"прямий":"реверсивний") + ": ");
        for (int i = 0; i < arrayNumbers.length; i++){
            System.out.print(arrayNumbers[i] + " ");
            clock--;
            if(clock<=0) {clock = 10; System.out.println();}

        }
        System.out.println();
    }
    static int[] CreateArray(int arrayCount){
        Random rndNumber = new Random();
        int[] tempArrayNumbers = new int[arrayCount];

        for (int i=0; i<arrayCount; i++){
            tempArrayNumbers[i] = rndNumber.nextInt(1,100);
        }

        return tempArrayNumbers;
    }

    static  int[] CreateReverseArray(int[] arrayNumbers){
        int[] tempArrayNumbers = new int[arrayNumbers.length];

        for (int i=0, j=arrayNumbers.length-1; i<tempArrayNumbers.length; i++, j--){
            tempArrayNumbers[i] = arrayNumbers[j];
        }
        return tempArrayNumbers;
    }

    static int[] SubArray (int[] arrayNumbers, Scanner scInput){
        System.out.println("Створення підмасиву ");
        int index;
        do{
            System.out.print("Введіть початковий елемент: ");
            index = scInput.nextInt();
            if(index<0) System.out.println("Початковий елемент не може бути менше 0.");
            else if(index>arrayNumbers.length-1) System.out.println("Початковий елемент не може бути більше розміру масива, тобто " +
                    (arrayNumbers.length-1));
            else break;
        }while(true);

        int count;
        do{
            System.out.print("Введіть розмір підмасиву: ");
            count = scInput.nextInt();
            if(count<=0) System.out.println("Розміп підмасива не може бути менше або дорівнювати 0.");
            else break;
        }while(true);

        return CreateSubArray (arrayNumbers, index, count);

    }

    static int[] CreateSubArray (int[] arrayNumbers, int startIndex, int count){
        int[] subArrayNumbers = new int[count];

        for(int i = 0; i < subArrayNumbers.length; i++){
            if(i+startIndex < arrayNumbers.length) subArrayNumbers[i] = arrayNumbers[i+startIndex];
            else subArrayNumbers[i] = 1;
        }
        return subArrayNumbers;
    }
}