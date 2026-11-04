package com.nonpolynomial.btleplug.android.impl;

/**
 * Tells btleplug that the phone's Bluetooth is turning off. Android closes every GATT client
 * without a callback then (see Peripheral.bluetoothTurnedOff), and btleplug has no Context to
 * listen for it itself, so the app calls turnedOff() from a receiver for
 * BluetoothAdapter.ACTION_STATE_CHANGED on STATE_TURNING_OFF or STATE_OFF. Call it off the main
 * thread: it reaches Rust through JNI.
 */
public final class BluetoothState {
    private BluetoothState() {}

    /** The adapter is turning off or is off. Safe to call more than once. */
    public static void turnedOff() {
        Peripheral.bluetoothTurnedOff();
    }
}
