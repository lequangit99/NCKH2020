package com.nckh.nckh2020.ta;

/**
 * Created by canbay on 24.12.2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nckh.nckh2020.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by alfiroj on 5/13/16.
 */
public class DBAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CocuklarIcinIngilizceQuiz";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESION = "question";
    private static final String KEY_QUESION_Imageid = "imageid";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d


    private SQLiteDatabase myDatabase;

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESION_Imageid + " INTEGER ," + KEY_QUESION
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT)";

        db.execSQL(sql);

        addQuestionsWithImage();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

        // Create tables again
        onCreate(db);
    }

    public int rowCount() {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }

    static List<Question> copy;

    // copying random list to the see true/wrong answers..
    public static List<Question> pickNRandom(List<Question> lst, int n) {
        copy = new ArrayList<Question>(lst);
        Collections.shuffle(copy);
        return copy.subList(0, n);
    }

    static List<Question> quesList;

    public List<Question> getRandomQuestions() {

        int i = 0;
        quesList = new ArrayList<Question>();
        List<Question> randomList;

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase = this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToNext()) {
            do {
                Question quest = new Question();
                quest.setId(cursor.getInt(0));
                quest.setQUESTIONImageId(cursor.getInt(1));
                quest.setQUESTION(cursor.getString(2));
                quest.setANSWER(cursor.getString(3));
                quest.setOptionA(cursor.getString(4));
                quest.setOptionB(cursor.getString(5));
                quest.setOptionC(cursor.getString(6));
                quest.setOptionD(cursor.getString(7));

                quesList.add(quest);


            } while (cursor.moveToNext());

        }
        // return quest list
        randomList = pickNRandom(quesList, 10);
        copy = new ArrayList<Question>(randomList);
        copy.subList(0, 10);
        return randomList;
    }

    public static List<Question> getQuestionList() {
        return copy;
    }

    private void addQuestionsWithImage() {
        // adding new questions
        //format is question-option1-option2-option3-option4-answer

        Question q1 = new Question(R.drawable.apple, "Trong tiếng Anh, trái cây dưới đây được gọi là gì?", "Grape", "Apple", "Raspberry", "Melon", "Apple");
        this.addQuestionWithImage(q1);

        Question q2 = new Question(R.drawable._8, "Trong tiếng Anh, số dưới đây được đọc là gì?", "Nine", "Two", "Three", "Eight", "Eight");
        this.addQuestionWithImage(q2);

        Question q3 = new Question(R.drawable.pencilsharpener, "Đồ dùng này được gọi là gì?", "Desk", "Table", "Pencil Sharpener", "Pencil", "Pencil Sharpener");
        this.addQuestionWithImage(q3);

        Question q4 = new Question(R.drawable.red, "Màu sắc của con vật này là gì?", "Red", "Blue", "Yellow", "White", "Red");
        this.addQuestionWithImage(q4);

        Question q5 = new Question(R.drawable._3, "Trong tiếng Anh, số này được đọc là gì?", "Four", "Nine", "Seven", "Three", "Three");
        this.addQuestionWithImage(q5);

        Question q6 = new Question(R.drawable.banana, "Trong tiếng Anh, trái cây trên được gọi là gì?", "Grapefruit", "Watermelon", "Banana", "Apple", "Banana");
        this.addQuestionWithImage(q6);

        Question q7 = new Question(R.drawable.coconut, "Trong tiếng Anh, trái cây trên được gọi là gì?", "Grape", "Apple", "Coconut", "Banana", "Coconut");
        this.addQuestionWithImage(q7);

        Question q8 = new Question(R.drawable._5, "Trong tiếng Anh, số này được đọc là gì?", "Five", "Two", "Four", "Eight", "Five");
        this.addQuestionWithImage(q8);

        Question q9 = new Question(R.drawable.bag, "Trong tiếng Anh, đồ dùng này được gọi là gì?", "Desk", "Bag", "Chalk", "Pencil", "Bag");
        this.addQuestionWithImage(q9);

        Question q10 = new Question(R.drawable.white, "Màu sắc của con vật này là gì?", "Black", "Yellow", "Green", "White", "White");
        this.addQuestionWithImage(q10);

        Question q11 = new Question(R.drawable._7, "Trong tiếng Anh, số này được đọc là gì?", "Seven", "Nine", "Four", "Three", "Seven");
        this.addQuestionWithImage(q11);

        Question q12 = new Question(R.drawable.pazartesi, "Trong Tiếng Việt, trên đây là thứ mấy?", "Chủ nhật", "Thứ năm", "Thứ sáu", "Thứ hai", "Thứ hai");
        this.addQuestionWithImage(q12);

        Question q13 = new Question(R.drawable.sali, "Trong Tiếng Việt, trên đây là thứ mấy?", "Thứ ba", "Chủ nhật", "Thứ tư", "Thứ hai", "Thứ ba");
        this.addQuestionWithImage(q13);

        Question q14 = new Question(R.drawable.cumartesi, "Trong Tiếng Việt, trên đây là thứ mấy?", "Thứ hai", "Thứ sáu", "Chủ nhật", "Thứ bảy", "Thứ bảy");
        this.addQuestionWithImage(q14);

        Question q15 = new Question(R.drawable.carsamba, "Trong Tiếng Việt, trên đây là thứ mấy?", "Chủ nhật", "Thứ tư", "Thứ sáu", "Thứ hai", "Thứ tư");
        this.addQuestionWithImage(q15);

        Question q16 = new Question(R.drawable.blue, "Màu sắc của con vật này là gì?", "Black", "Blue", "Green", "White", "Blue");
        this.addQuestionWithImage(q16);

        Question q17 = new Question(R.drawable._9, "Trong tiếng Anh, số này được đọc là gì?", "Nine", "Ten", "Seven", "Four", "Nine");
        this.addQuestionWithImage(q17);

        Question q18 = new Question(R.drawable.cherry, "Trong tiếng Anh, trái cây dưới đây được gọi là gì?", "Cherry", "Watermelon", "Melon", "Apple", "Cherry");
        this.addQuestionWithImage(q18);

        Question q19 = new Question(R.drawable.eraser, "Trong tiếng Anh, đồ dùng này được gọi là gì?", "Chalk", "Desk", "Eraser", "Table", "Eraser");
        this.addQuestionWithImage(q19);

        Question q20 = new Question(R.drawable._1, "Trong tiếng Anh, số này được đọc là gì?", "One", "Two", "Seven", "Nine", "One");
        this.addQuestionWithImage(q20);

        Question q21 = new Question(R.drawable.camera, "Trong tiếng Anh, đồ vật này được gọi là gì?", "Car", "Door", "Computer", "Camera", "Camera");
        this.addQuestionWithImage(q21);

        Question q22 = new Question(R.drawable.yellow, "Màu sắc của con vật này là gì?", "Red", "Brown", "Yellow", "Blue", "Yellow");
        this.addQuestionWithImage(q22);

        Question q23 = new Question(R.drawable._2, "Trong tiếng Anh, số này được đọc là gì?", "Four", "Nine", "Two", "Ten", "Two");
        this.addQuestionWithImage(q23);

        Question q24 = new Question(R.drawable.grape, "Trong tiếng Anh, trái cây dưới đây được gọi là gì?", "Grape", "Melon", "Apple", "Blueberry", "Grape");
        this.addQuestionWithImage(q24);

        Question q25 = new Question(R.drawable.rooster, "Trong tiếng Anh, con vật này được gọi là gì?", "Dog", "Monkey", "Donkey", "Rooster", "Rooster");
        this.addQuestionWithImage(q25);

        Question q26 = new Question(R.drawable._5, "Trong tiếng Anh, số này được đọc là gì?", "Five", "Two", "Four", "Twelve", "Five");
        this.addQuestionWithImage(q26);

        Question q27 = new Question(R.drawable.microscope, "Trong tiếng Anh, đồ vật này được gọi là gì?", "Car", "Microscope", "Pencil Sharpener", "Phone", "Microscope");
        this.addQuestionWithImage(q27);

        Question q28 = new Question(R.drawable.green, "Màu sắc của con vật này là gì?", "Red", "Blue", "Green", "White", "Green");
        this.addQuestionWithImage(q28);

        Question q29 = new Question(R.drawable._4, "Trong tiếng Anh, số này được đọc là gì?", "Four", "Seven", "Eight", "Three", "Four");
        this.addQuestionWithImage(q29);

        Question q30 = new Question(R.drawable.donkey, "Trong tiếng Anh, con vật này được gọi là gì?", "Monkey", "Donkey", "Rooster", "Cat", "Donkey");
        this.addQuestionWithImage(q30);

    }

    // Adding new question

    public void addQuestionWithImage(Question quest) {

        // Inserting attributes to the table Question
        ContentValues values = new ContentValues();
        values.put(KEY_QUESION_Imageid, quest.getQUESTIONImageId());
        values.put(KEY_QUESION, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOptionA());
        values.put(KEY_OPTB, quest.getOptionB());
        values.put(KEY_OPTC, quest.getOptionC());
        values.put(KEY_OPTD, quest.getOptionD());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTION, null, values);
    }


}
