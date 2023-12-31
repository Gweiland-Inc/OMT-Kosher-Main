package com.omt.omtkosher;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.button.MaterialButton;
import com.omt.omtkosher.databinding.FragmentEnrollmentBinding;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnrollmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnrollmentFragment extends Fragment {

    private FragmentEnrollmentBinding binding2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnrollmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnrollmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnrollmentFragment newInstance(String param1, String param2) {
        EnrollmentFragment fragment = new EnrollmentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding2 = FragmentEnrollmentBinding.inflate(inflater, container, false);
        View v= binding2.getRoot();

        NavHostFragment navHostFragment =
                (NavHostFragment) requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        MaterialButton btn = binding2.nxtbtn;






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Objects.requireNonNull(binding2.enrollMail.getText()).toString().trim().length()==0){
                    binding2.enrollMail.setError("Enter Mail - הזן דואר");
                }
                else if(Objects.requireNonNull(binding2.enrollName.getText()).toString().trim().length()==0){
                    binding2.enrollName.setError("Enter Name - הכנס שם");
                }
                else if(Objects.requireNonNull(binding2.enrollNumber.getText()).toString().trim().length()==0){
                    binding2.enrollNumber.setError("Enter Number - הכנס מספר");
                }
                else{
                    navController.navigate(R.id.parentalFragment);
                }



            }
        });




        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Access the view in the parent activity
        ((EnrollmentActivity) requireActivity()).binding.included1.tv.setBackgroundResource(R.drawable.circle);
        ((EnrollmentActivity) requireActivity()).binding.included2.tv.setBackgroundResource(R.drawable.circleundone);
        ((EnrollmentActivity) requireActivity()).binding.included3.tv.setBackgroundResource(R.drawable.circleundone);
        ((EnrollmentActivity) requireActivity()).binding.included4.tv.setBackgroundResource(R.drawable.circleundone);


        // Use the view as needed
        ((EnrollmentActivity) requireActivity()).binding.space1.setBackgroundColor(Color.parseColor("#9ec4f1"));
        ((EnrollmentActivity) requireActivity()).binding.space2.setBackgroundColor(Color.parseColor("#9ec4f1"));
        ((EnrollmentActivity) requireActivity()).binding.space3.setBackgroundColor(Color.parseColor("#9ec4f1"));


    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding2 = null;
    }
}