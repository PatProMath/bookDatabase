package com.example.bookdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore firebaseFirestore;
    EditText name, author, pyear, price ;
    Button addBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseFirestore = FirebaseFirestore.getInstance();
        name = findViewById(R.id.book_name);
        author = findViewById(R.id.book_author);
        pyear = findViewById(R.id.pub_year);
        price = findViewById(R.id.price);
        addBook = findViewById(R.id.button);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bookName = name.getText().toString();
                String bookAuthor = author.getText().toString();
                String pubYear = pyear.getText().toString();
                String bookPrice = price.getText().toString();

                Map<String, Object> book = new HashMap<>();
                if (!TextUtils.isEmpty(bookName) || !TextUtils.isEmpty(bookAuthor) || !TextUtils.isEmpty(pubYear) && !TextUtils.isEmpty(bookPrice) ) {
                    Double price = Double.parseDouble(bookPrice);
                    BookModel bookModel = new BookModel(bookName, bookAuthor, pubYear, price);
                    // add data to the hashmap using the data given by the user
                    book.put("name",bookModel.bookName);
                    book.put("author", bookModel.bookAuthor);
                    book.put("publication year", bookModel.pubYear);
                    book.put("price", bookModel.price);

                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_LONG).show();
                }

                firebaseFirestore.collection("booksDB")
                        .add(book)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(MainActivity.this, "Book Information inputted successfully", Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Input failed!", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });



    }
}