file_path = 'result.txt'
file = open(file_path, 'r')
lines = file.read().split('\n')
paths = []
for line in lines:
    if '200' in line:
        path = line.split('-')[-1].strip()
        paths.append(path)

print(paths)