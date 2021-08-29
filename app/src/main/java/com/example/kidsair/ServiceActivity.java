package com.example.kidsair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    private RecyclerNoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        init();
        getData();

    }

    private void getData() {
        List<String> listTitle = Arrays.asList("공지사항1", "공지사항2", "공지사항3", "공지사항4", "공지사항5", "공지사항6", "공지사항7", "공지사항8", "공지사항9");
        List<String> listContent = Arrays.asList(
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠",
                "공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠. 공지사항 내용입니다. 궁금한거 없죠? 나도 뭔지 모르겠죠"
                );

        for (int i = 0; i < listTitle.size(); i++){
            NoticeData data = new NoticeData();
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));

            adapter.addItem(data);
        }
        adapter.notifyDataSetChanged();
    }

    private void init(){
        RecyclerView recyclerView =findViewById(R.id.recylerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerNoticeAdapter();
        recyclerView.setAdapter(adapter);
    }
}