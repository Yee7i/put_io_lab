package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    private int previous_usb_count;

    public void update(SystemMonitor monitor) {
        SystemState lastSystemState = monitor.getLastSystemState();
        if(lastSystemState.getUsbDevices() != this.previous_usb_count){
                System.out.println("> Number of USB devices has changed");
        }
        this.previous_usb_count = lastSystemState.getUsbDevices();
    }
}

