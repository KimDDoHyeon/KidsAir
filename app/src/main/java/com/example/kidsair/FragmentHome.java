package com.example.kidsair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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

    private ViewGroup viewGroup; // 뷰그룹 객체 선언

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
        // 뷰그룹 인플레이션 한 뒤 viewGroup에 리턴해 줌
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        // 이 프래그먼트에 메서드를 하나 임의로 호출함
        setInit(); // 뷰페이저2 실행 메서드

//        return fragView;
        return viewGroup;

    }

    private void setInit() { // 뷰페이저2 실행 메서드
        /* setup infinity scroll viewpager */
        ViewPager2 viewPageSetUp = viewGroup.findViewById(R.id.view_pager2); // 여기서 뷰페이저를 참조

        // 프래그먼트에서는 getActivity로 참조하고, 액티비티에서는 this를 사용함
        ViewPagerAdapter SetupPagerAdapter = new ViewPagerAdapter(getActivity());

        // ViewPagerAdapter를 파라미터로 받고 ViewPager2에 전달 받는다.
        viewPageSetUp.setAdapter(SetupPagerAdapter);
        viewPageSetUp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL); // 방향은 가로로
        viewPageSetUp.setOffscreenPageLimit(3); //페이지 한계 지정 갯수

        // 무제한 스크롤 처럼 보이기 위해서는 0페이지 부터가 아니라 1000페이지 부터 시작해서 좌측으로 이동할 경우 999페이지로 이동하여 무제한 처럼 스크롤 되는 것 처럼 표현하기 위함.
//        viewPageSetUp.setCurrentItem(1000);

        final float pageMargin = (float) getResources().getDimensionPixelOffset(R.dimen.pageMargin); //페이지끼리 간격
        final float pageOffset = (float) getResources().getDimensionPixelOffset(R.dimen.offset); //페이지 보이는 정도

        viewPageSetUp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }
        });
        viewPageSetUp.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float offset = position * - (2 * pageOffset + pageMargin);
                if(-1 > position) {
                    page.setTranslationX(-offset);
                } else if(1 >= position) {
                    float scaleFactor = Math.max(0.7f, 1 - Math.abs(position - 0.14285715f));
                    page.setTranslationX(offset);
                    page.setScaleY(scaleFactor);
                    page.setAlpha(scaleFactor);
                } else {
                    page.setAlpha(0f);
                    page.setTranslationX(offset);
                }
            }
        });
    }

}