package com.example.kidsair;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter { //뷰페이저2에서는 FragmentStateAdapter를 사용한다.
    // Real Fragment Total Count
    private final int mSetItemCount = 3; //프래그먼트 갯수 지정

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int iViewIdx = getRealPosition(position);
        switch( iViewIdx ) {
            case 0    : { return new ViewPagerHome1(); } //프래그먼트 순서에 맞게 넣어주세요.
            case 1    : { return new ViewPagerHome2(); }
            case 2    : { return new ViewPagerHome3(); }
//            case 3    : { return new Frag4(); }
//            case 4    : { return new Frag5(); }
//            case 5    : { return new Frag6(); }
            default   : { return new ViewPagerHome1(); } //기본으로 나와있는 프래그먼트
        }

    }

    public int getRealPosition(int _iPosition){
        return _iPosition % mSetItemCount;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
