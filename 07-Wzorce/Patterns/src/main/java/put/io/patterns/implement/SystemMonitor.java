package put.io.patterns.implement;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.List;
public class SystemMonitor {
    private SystemInfo si;
    private HardwareAbstractionLayer hal;
    private OperatingSystem os;
    private SystemState lastSystemState = null;
    private List<SystemStateObserver> observers = new ArrayList<SystemStateObserver>();
    public void addSystemStateObserver(SystemStateObserver observer){
        this.observers.add(observer);
    }
    public void removeSystemStateObserver(SystemStateObserver observer){
        this.observers.remove(observer);
    }

    public void notifyObservers(){
        for(SystemStateObserver observer : this.observers){
            observer.update(this);
        }
    }
    public void probe(){
        // Get current state of the system resources
        double cpuLoad = hal.getProcessor().getSystemLoadAverage(1)[0];
        double cpuTemp = hal.getSensors().getCpuTemperature();
        double memory = hal.getMemory().getAvailable() / 1000000;
        int usbDevices = hal.getUsbDevices(false).size();

        this.lastSystemState = new SystemState(cpuLoad, cpuTemp, memory, usbDevices);
        notifyObservers();
    }

    public SystemMonitor(){
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
    }
    public SystemState getLastSystemState() {
        return lastSystemState;
    }
}
