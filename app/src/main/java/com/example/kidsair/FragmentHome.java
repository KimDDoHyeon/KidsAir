package com.example.kidsair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FragmentHome extends Fragment {

    ViewPagerAdapter pagerAdapter;
    ViewPager2 pager2;
    int list[];

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_home, container, false);

        // 스피너
        Spinner spinner = (Spinner) fragView.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(fragView.getContext(),
                R.array.spinner_array, R.layout.spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 항목 선택 시, 그래프 수치 변경
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // 뷰페이저
        pager2 = fragView.findViewById(R.id.view_pager2);

        return fragView;
    }

}