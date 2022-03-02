package com.example.cadeaucommun.FEL.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cadeaucommun.BLL.Model.Gift;
import com.example.cadeaucommun.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link giftCreationFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class giftCreationFragment extends Fragment {

    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM2 = "description";
    private static final String ARG_PARAM3 = "image";
    private static final String ARG_PARAM4 = "goal";

    private String title;
    private String desc;
    private String img;
    private double goal;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Gift title.
     * @param desc Gift description.
     * @param img Gift image URL link.
     * @param goal Amount needed to buy said gift.
     * @return A new instance of fragment giftCreationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static giftCreationFragment newInstance(String title, String desc, String img, double goal) {
        giftCreationFragment fragment = new giftCreationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, desc);
        args.putString(ARG_PARAM3, img);
        args.putDouble(ARG_PARAM4, goal);
        fragment.setArguments(args);
        return fragment;
    }

    public giftCreationFragment() {
        // Required empty public constructor
    }

    public giftCreationFragment(String title, String desc, String img, double goal) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.goal = goal;
        new Gift(title, desc, img, goal);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            desc = getArguments().getString(ARG_PARAM2);
            img = getArguments().getString(ARG_PARAM3);
            goal = getArguments().getDouble(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gift_creation, container, false);
    }
}