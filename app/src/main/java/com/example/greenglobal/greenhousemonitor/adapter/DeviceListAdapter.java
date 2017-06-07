package com.example.greenglobal.greenhousemonitor.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.greenglobal.greenhousemonitor.R;
import com.example.greenglobal.greenhousemonitor.model.BluetoothDeviceWrapper;
import com.example.greenglobal.greenhousemonitor.model.HexiwearDevice;
import com.example.greenglobal.greenhousemonitor.util.HexiwearDevices;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EBean
public class DeviceListAdapter extends BaseAdapter {

    private final List<BluetoothDeviceWrapper> devices = new ArrayList<>();

    @RootContext
    Context context;

    @Bean
    static HexiwearDevices hexiwearDevices;

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public BluetoothDeviceWrapper getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @UiThread
    public void add(BluetoothDeviceWrapper wrapper) {
        for (BluetoothDeviceWrapper deviceWrapper : devices) {
            if(deviceWrapper.getDevice().getAddress().equals(wrapper.getDevice().getAddress())) {
                return;
            }
        }

        devices.add(wrapper);
        notifyDataSetChanged();
    }

    @UiThread
    public void clear() {
        devices.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DeviceItemView deviceItemView;
        //if (convertView == null) {
            //TODO: Not implemented
            //deviceItemView = DeviceListAdapter_.DeviceItemView_.build(context);
        //} else {
            deviceItemView = (DeviceItemView) convertView;
        //}
        //TODO: not implemented
        //deviceItemView.bind(getItem(position));
        return deviceItemView;
    }

    //@EViewGroup(R.layout.item_device)
    public static class DeviceItemView extends LinearLayout {

        //@ViewById
        TextView deviceName;

        //@ViewById
        TextView deviceUUID;

        //@ViewById
        TextView status;

        //@ViewById
        ImageView signalStrength;

        //@ViewById
        TextView otapMode;

        public DeviceItemView(Context context) {
            super(context);
        }

        void bind(BluetoothDeviceWrapper wrapper) {
            final BluetoothDevice device = wrapper.getDevice();

            //TODO: where did getName() come from?
            //final String name = device.getName();
            final String name = "Hexiwear";
            final HexiwearDevice hexiwearDevice = hexiwearDevices.getDevice(device.getAddress());
            if (hexiwearDevice != null) {
                deviceName.setText(hexiwearDevice.getWolkName());
            } else if (!TextUtils.isEmpty(name)) {
                deviceName.setText(name);
            } else {
                deviceName.setText(device.getAddress());
            }

            //TODO: Set bonded state
            //status.setVisibility(device.getBondState() == BluetoothDevice.BOND_BONDED ? VISIBLE : GONE);

            deviceUUID.setText(device.getAddress());
            signalStrength.setImageResource(wrapper.getSignalStrength());
            otapMode.setVisibility(wrapper.isInOtapMode() ? VISIBLE : GONE);
        }

    }

}
