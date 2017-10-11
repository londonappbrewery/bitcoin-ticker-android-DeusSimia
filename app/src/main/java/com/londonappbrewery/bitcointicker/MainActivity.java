package com.londonappbrewery.bitcointicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static android.R.attr.value;


public class MainActivity extends AppCompatActivity {

    // Constants:
    // TODO: Create the base URL
    private final String BASE_URL = "https://blockchain.info/ticker";

    // Member Variables:
    TextView mPriceBuyTV;
    TextView mPriceSellTV;
    String mCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceBuyTV = (TextView) findViewById(R.id.buyPrice);
        mPriceSellTV = (TextView) findViewById(R.id.sellPrice);
        final Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // TODO: Set an OnItemSelected listener on the spinner
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Bitcoin", "" + parent.getItemAtPosition(position));
                final String currency = spinner.getItemAtPosition(position).toString();
                Log.d("Bitcoin", "String currency says " + currency);
                setCurrency(currency);

                letsDoSomeNetworking(BASE_URL);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Bitcoin", "Nothing selected");
            }
        });
    }

    // TODO: complete the letsDoSomeNetworking() method
    private void letsDoSomeNetworking(String BASE_URL) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(BASE_URL, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // called when response HTTP status is "200 OK"
                Log.d("Bitcoin", "JSON: " + response.toString());
                Parsing mPriceJson = Parsing.fromJson(response);
                updateUI(mPriceJson);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("Bitcoin", "Request fail! Status code: " + statusCode);
                Log.d("Bitcoin", "Fail response: " + response);
                Log.e("ERROR", e.toString());
            }
        });
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    private void updateUI(Parsing parse) {

        if (mCurrency.equals("AUD")) {
            mPriceBuyTV.setText(parse.getAUDbuy());
            mPriceSellTV.setText(parse.getAUDsell());
        }
        if (mCurrency.equals("BRL")) {
            mPriceBuyTV.setText(parse.getBRLbuy());
            mPriceSellTV.setText(parse.getBRLsell());
        }
        if (mCurrency.equals("CAD")) {
            mPriceBuyTV.setText(parse.getCADbuy());
            mPriceSellTV.setText(parse.getCADsell());
        }
        if (mCurrency.equals("CHF")) {
            mPriceBuyTV.setText(parse.getCHFbuy());
            mPriceSellTV.setText(parse.getCHFsell());
        }
        if (mCurrency.equals("CLP")) {
            mPriceBuyTV.setText(parse.getCLPbuy());
            mPriceSellTV.setText(parse.getCLPsell());
        }
        if (mCurrency.equals("CNY")) {
            mPriceBuyTV.setText(parse.getCNYbuy());
            mPriceSellTV.setText(parse.getCNYsell());
        }
        if (mCurrency.equals("DKK")) {
            mPriceBuyTV.setText(parse.getDKKbuy());
            mPriceSellTV.setText(parse.getDKKsell());
        }
        if (mCurrency.equals("EUR")) {
            mPriceBuyTV.setText(parse.getEURbuy());
            mPriceSellTV.setText(parse.getEURsell());
        }
        if (mCurrency.equals("GBP")) {
            mPriceBuyTV.setText(parse.getGBPbuy());
            mPriceSellTV.setText(parse.getGBPsell());
        }
        if (mCurrency.equals("HKD")) {
            mPriceBuyTV.setText(parse.getHKDbuy());
            mPriceSellTV.setText(parse.getHKDsell());
        }
        if (mCurrency.equals("ISK")) {
            mPriceBuyTV.setText(parse.getISKbuy());
            mPriceSellTV.setText(parse.getISKsell());
        }
        if (mCurrency.equals("JPY")) {
            mPriceBuyTV.setText(parse.getJPYbuy());
            mPriceSellTV.setText(parse.getJPYsell());
        }
        if (mCurrency.equals("KRW")) {
            mPriceBuyTV.setText(parse.getKRWbuy());
            mPriceSellTV.setText(parse.getKRWsell());
        }
        if (mCurrency.equals("NZD")) {
            mPriceBuyTV.setText(parse.getNZDbuy());
            mPriceSellTV.setText(parse.getNZDsell());
        }
        if (mCurrency.equals("PLN")) {
            mPriceBuyTV.setText(parse.getPLNbuy());
            mPriceSellTV.setText(parse.getPLNsell());
        }
        if (mCurrency.equals("RUB")) {
            mPriceBuyTV.setText(parse.getRUBbuy());
            mPriceSellTV.setText(parse.getRUBsell());
        }
        if (mCurrency.equals("SEK")) {
            mPriceBuyTV.setText(parse.getSEKbuy());
            mPriceSellTV.setText(parse.getSEKsell());
        }
        if (mCurrency.equals("SGD")) {
            mPriceBuyTV.setText(parse.getSGDbuy());
            mPriceSellTV.setText(parse.getSGDsell());
        }
        if (mCurrency.equals("THB")) {
            mPriceBuyTV.setText(parse.getTHBbuy());
            mPriceSellTV.setText(parse.getTHBsell());
        }
        if (mCurrency.equals("TWD")) {
            mPriceBuyTV.setText(parse.getTWDbuy());
            mPriceSellTV.setText(parse.getTWDsell());
        }
        if (mCurrency.equals("USD")) {
            mPriceBuyTV.setText(parse.getUSDbuy());
            mPriceSellTV.setText(parse.getUSDsell());
        }
    }
}



