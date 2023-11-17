import subprocess

# Define the path to your BIDS dataset
bids_dataset_path = "/home/mouhameden/Téléchargements/bids-examples-master/test"

# Run the BIDS Validator tool
cmd = ["bids-validator", bids_dataset_path]
result = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)

# Print the validation results
#print(result.stdout)

# Check the exit code to determine if validation was successful (0) or not (non-zero)
if result.returncode == 0:
    print("BIDS validation successful.")
else:
    print("BIDS validation failed.")
















