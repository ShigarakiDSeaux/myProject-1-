from time import sleep
import requests
from datetime import datetime
import nfc
from nfc.clf import RemoteTarget

def main():
    while True:
        punch_Post()

def scan_tag():
    print("Please Scan NFC Tag")
    with nfc.ContactlessFrontend('tty:S0') as clf:
        is_connected = True

        while is_connected == True:
            target = clf.sense(RemoteTarget('106A'))

            if target is None:
                sleep(0.1)
                continue

            tag = nfc.tag.activate(clf, target)

            if tag is None or tag.ndef is None:
#                 print("No NDEF records found!")
                continue

            else:
                for record in tag.ndef.records:
                    record = record.text
                    is_connected = False
    return record

def date_time():
    now = datetime.now()
    current_time = now.strftime("%m/%d/%Y %I:%M:%S %p")
    return current_time

def in_N_out():
    while True:
        status = input("What kind of scan is this? (In/Out/Lunch)")
        if status not in ("In", "Out", "Lunch"):
            print("Please enter either In, Out, or Lunch")
        else:
            break
    return status

def punch_Post():
    link = "https://script.google.com/macros/s/AKfycbyTogt_2ZM5KGO5kdu3GCrP5P14OalnR-pp5sjGaRbOW-shM5DiWEHUducWh99_r6_SHw/exec"
    name = scan_tag()
    dt = date_time()
    status = in_N_out()
    data = {"name":name,"status":status,"dt":dt}
    r = requests.post(url = link, data = data)
    print("Thank You " + name + "! Your "  + status + " punch has been recorded at " + dt)

if __name__ == "__main__":
    main()