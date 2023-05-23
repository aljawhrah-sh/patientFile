package dsassignment;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int option;
        do {

            displayMenu();

            option = input.nextInt();

            switch (option) {
                case 1:
                    mergeLists();
                    break;

                case 2:
                    mergeStacks();
                    break;

                case 3:
                    mergeQueues();
                    break;

                case 4:
                    mergeListStack();
                    break;

                case 5:
                    mergeListQueue();
                    break;
                case 6:
                    mergeListStackQueue();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Selection!");
            }

        } while (option != 7);

    }

    public static void displayMenu() {
        System.out.print("** Welcome to the Data structure Merging Assignment** \n"
                + "1:Merging two Single Linked List data structure type\n"
                + "2:Merging two Stacks data structure type\n"
                + "3:Merging two Queses data structure type\n"
                + "4:Merging Single Linked List with Stack to Linked List\n"
                + "5:Merging Single Linked List with Queue to Linked List\n"
                + "6:Merging Singly Linked List with Stack only Patient’s name that start with S to Queue\n"
                + "7:Exit\n"
                + "Your selection is: ");
    }

    /*-------------------------------------------------------------------------
       LinkedList
     */
    public static void mergeLists() {

        //first list
        System.out.print("Please enter the first linked list size: ");
        int firstSize = input.nextInt();
        SinglyLinkedList<PatientInfo> firstList = new SinglyLinkedList<>();
        System.out.println("Please enter " + firstSize + " patients info: ");

        //read first linked list patients from the user(based on size)
        for (int i = 0; i < firstSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to list
            firstList.addLast(patient);
        }

        //second list
        System.out.print("Please enter the second linked list size: ");
        int secondSize = input.nextInt();
        SinglyLinkedList<PatientInfo> secondList = new SinglyLinkedList<>();
        System.out.println("Please enter " + secondSize + " patients info: ");

        //read second linked list patients from the user(based on size)
        for (int i = 0; i < secondSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to list
            secondList.addLast(patient);
        }

        //merge List
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();

        //copy first
        for (int i = 0; i < firstSize; i++) {
            PatientInfo patient = firstList.removeFirst();
            firstList.addLast(patient);
            mergedList.addLast(patient);
        }

        //copy second
        for (int i = 0; i < secondSize; i++) {
            PatientInfo patient = secondList.removeFirst();
            secondList.addLast(patient);
            mergedList.addLast(patient);
        }

        System.out.println("-------Lists Before Merging-------");
        System.out.println("The First Given Linked List:");
        firstList.print();

        System.out.println("The Second Given Linked List:");
        secondList.print();

        System.out.println("-------List After Merging-------");
        mergedList.print();
    }

    /*-------------------------------------------------------------------------
       Stack
     */
    public static void mergeStacks() {
        //first stack
        System.out.print("Please enter the first stack size: ");
        int firstSize = input.nextInt();
        LLStack<PatientInfo> firstStack = new LLStack<>();
        System.out.println("Please enter " + firstSize + " patients info: ");
        for (int i = 0; i < firstSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to stack
            firstStack.push(patient);
        }

        //second stack
        System.out.print("Please enter the second stack size: ");
        int secondSize = input.nextInt();
        LLStack<PatientInfo> secondStack = new LLStack<>();
        System.out.println("Please enter " + secondSize + " patients info: ");
        for (int i = 0; i < secondSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to stack
            secondStack.push(patient);
        }

        //merge
        LLStack<PatientInfo> mergedStack = new LLStack<>();
        LLStack<PatientInfo> temp = new LLStack<>();

        //copy first       
        while (!firstStack.isEmpty()) {
            PatientInfo patient = firstStack.pop();
            temp.push(patient);
        }
        while (!temp.isEmpty()) {
            PatientInfo patient = temp.pop();
            mergedStack.push(patient);
            firstStack.push(patient);
        }

        //copy second
        while (!secondStack.isEmpty()) {
            PatientInfo patient = secondStack.pop();
            temp.push(patient);
        }
        while (!temp.isEmpty()) {
            PatientInfo patient = temp.pop();
            mergedStack.push(patient);
            secondStack.push(patient);
        }

        //print
        System.out.println("-------Stacks Before Merging-------");

        System.out.println("The First given Stack:");
        firstStack.print();

        System.out.println("The Second given Stack:");
        secondStack.print();

        System.out.println("-------Stack After Merging-------");
        mergedStack.print();
    }

    /*-------------------------------------------------------------------------
       Queue
     */
    public static void mergeQueues() {

        //first queue
        System.out.print("Please enter the first queue size: ");
        int firstSize = input.nextInt();
        LLQueue<PatientInfo> firstQueue = new LLQueue<>();
        System.out.println("Please enter " + firstSize + " patients info: ");
        for (int i = 0; i < firstSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            firstQueue.enqueue(patient);
        }

        //second queue
        System.out.print("Please enter the second queue size: ");
        int secondSize = input.nextInt();
        LLQueue<PatientInfo> secondQueue = new LLQueue<>();
        System.out.println("Please enter " + secondSize + " patients info: ");
        for (int i = 0; i < secondSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            secondQueue.enqueue(patient);
        }

        //merge
        LLQueue<PatientInfo> mergedQueue = new LLQueue<>();

        //copy first
        for (int i = 0; i < firstSize; i++) {
            PatientInfo patient = firstQueue.dequeue();
            firstQueue.enqueue(patient);
            mergedQueue.enqueue(patient);
        }

        //copy second
        for (int i = 0; i < secondSize; i++) {
            PatientInfo patient = secondQueue.dequeue();
            secondQueue.enqueue(patient);
            mergedQueue.enqueue(patient);
        }

        System.out.println("-------Queues Before Merging-------");

        System.out.println("The First given Queue:");
        firstQueue.print();

        System.out.println("The Second given Queue:");
        secondQueue.print();

        System.out.println("-------Queue After Merging-------");
        mergedQueue.print();
    }

    /*-------------------------------------------------------------------------
       LinkedList with Stack
     */
    public static void mergeListStack() {
        // list
        System.out.print("Please enter the linked list size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");

        //read linked list patients from the user(based on size)
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to list
            list.addLast(patient);
        }

        // stack
        System.out.print("Please enter the stack size: ");
        int stackSize = input.nextInt();
        LLStack<PatientInfo> stack = new LLStack<>();
        System.out.println("Please enter " + stackSize + " patients info: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to stack
            stack.push(patient);
        }

        //merge List
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();

        //copy list
        for (int i = 0; i < listSize; i++) {
            PatientInfo patient = list.removeFirst();
            list.addLast(patient);
            mergedList.addLast(patient);
        }

        //copy stack       
        LLStack<PatientInfo> temp = new LLStack<>();
        while (!stack.isEmpty()) {
            PatientInfo patient = stack.pop();
            temp.push(patient);
        }
        while (!temp.isEmpty()) {
            PatientInfo patient = temp.pop();
            mergedList.addLast(patient);
            stack.push(patient);
        }

        //print
        System.out.println("-------List and Stack Before Merging-------");
        System.out.println("The Given Linked List:");
        list.print();

        System.out.println("The Given Stack:");
        stack.print();

        System.out.println("-------List After Merging-------");
        mergedList.print();
    }

    /*-------------------------------------------------------------------------
       LinkedList with Queue
     */
    public static void mergeListQueue() {
        // list
        System.out.print("Please enter the linked list size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");

        //read linked list patients from the user(based on size)
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to list
            list.addLast(patient);
        }

        // queue
        System.out.print("Please enter the queue size: ");
        int queueSize = input.nextInt();
        LLQueue<PatientInfo> queue = new LLQueue<>();
        System.out.println("Please enter " + queueSize + " patients info: ");
        for (int i = 0; i < queueSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            queue.enqueue(patient);
        }

        //merge List
        SinglyLinkedList<PatientInfo> mergedList = new SinglyLinkedList<>();

        //copy list
        for (int i = 0; i < listSize; i++) {
            PatientInfo patient = list.removeFirst();
            list.addLast(patient);
            mergedList.addLast(patient);
        }

        //copy queue
        for (int i = 0; i < queueSize; i++) {
            PatientInfo patient = queue.dequeue();
            queue.enqueue(patient);
            mergedList.addLast(patient);
        }

        //print
        System.out.println("-------List and Queue Before Merging-------");
        System.out.println("The Given Linked List:");
        list.print();

        System.out.println("The Given Queue:");
        queue.print();

        System.out.println("-------List After Merging-------");
        mergedList.print();
    }

    /*-------------------------------------------------------------------------
       LinkedList with Stack to Queue
     */
    public static void mergeListStackQueue() {
        // list
        System.out.print("Please enter the linked list size: ");
        int listSize = input.nextInt();
        SinglyLinkedList<PatientInfo> list = new SinglyLinkedList<>();
        System.out.println("Please enter " + listSize + " patients info: ");

        //read linked list patients from the user(based on size)
        for (int i = 0; i < listSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to list
            list.addLast(patient);
        }

        // stack
        System.out.print("Please enter the stack size: ");
        int stackSize = input.nextInt();
        LLStack<PatientInfo> stack = new LLStack<>();
        System.out.println("Please enter " + stackSize + " patients info: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print("Enter patient #" + (i + 1) + " id: ");
            int patientId = input.nextInt();
            input.nextLine();
            System.out.print("Enter patient #" + (i + 1) + " name: ");
            String patientName = input.nextLine();
            PatientInfo patient = new PatientInfo();
            patient.setPatientID(patientId);
            patient.setPatientName(patientName);

            //add to stack
            stack.push(patient);
        }

        //merge
        LLQueue<PatientInfo> mergedQueue = new LLQueue<>();

        //copy list
        for (int i = 0; i < listSize; i++) {
            PatientInfo patient = list.removeFirst();
            char firstLetter = patient.getPatientName().toUpperCase().charAt(0);
            if (firstLetter == 'S') {
                mergedQueue.enqueue(patient);
            }
            list.addLast(patient);
        }

        //copy stack
        LLStack<PatientInfo> temp = new LLStack<>();
        while (!stack.isEmpty()) {
            PatientInfo patient = stack.pop();
            temp.push(patient);
        }
        while (!temp.isEmpty()) {
            PatientInfo patient = temp.pop();
            char firstLetter = patient.getPatientName().toUpperCase().charAt(0);
            if (firstLetter == 'S') {
                mergedQueue.enqueue(patient);
            }
            stack.push(patient);
        }

        //print
        System.out.println("-------List and Stack Before Merging-------");
        System.out.println("The Given Linked List:");
        list.print();

        System.out.println("The Given Stack:");
        stack.print();

        System.out.println("-------Queue After Merging Patients Start with Letter S-------");
        mergedQueue.print();
    }

}
