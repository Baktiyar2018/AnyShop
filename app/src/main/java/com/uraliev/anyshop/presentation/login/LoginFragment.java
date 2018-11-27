package com.uraliev.anyshop.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uraliev.anyshop.MainActivity;
import com.uraliev.anyshop.R;
import com.uraliev.anyshop.data.RepositoryProvider;
import com.uraliev.anyshop.data.product.ProductDataSource;
import com.uraliev.anyshop.model.Product;

import java.util.List;


public class LoginFragment extends Fragment
        implements LoginContract.View {

    private LoginContract.Presenter mPresenter = null;

    private EditText mNameInput;
    private EditText mPasswordInput;
    private Button mLoginBtn;

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    //region Lifecycle

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        init(rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    //endregion



    @Override
    public void onResume() {
        super.onResume();
        RepositoryProvider.getProductRepository().getProducts(new ProductDataSource.ProductsCallback() {


            @Override
            public void onSuccess(List<Product> result) {
                for(Product product :result){
                    Log.d("ololo",product.toString());
                }
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    private void init(View rootView){
        mLoginBtn = rootView.findViewById(R.id.fragment_login_btn);
        mNameInput = rootView.findViewById(R.id.fragment_login_name);
        mPasswordInput = rootView.findViewById(R.id.fragment_login_password);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPresenter != null) {
                    mPresenter.onLoginClick(
                            mNameInput.getText().toString(),
                            mPasswordInput.getText().toString()
                    );
                }
            }
        });
    }

    //region Contract


    @Override
    public void finishView() {
        if (getActivity() != null){
            getActivity().finish();
        }
    }

    @Override
    public void attachPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoginSuccess() {
        if (getActivity() != null) {
            getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    //endregion

}
