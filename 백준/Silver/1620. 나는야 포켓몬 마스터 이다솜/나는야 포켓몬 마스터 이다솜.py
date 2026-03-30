import sys

n , m = map(int, sys.stdin.readline().split())
poke_id = {}
poke_name = {}

for i in range(1,n+1):
    pokemon = sys.stdin.readline().rstrip()
    poke_id[i] = pokemon
    poke_name[pokemon] = i

for _ in range(m):
    x = input()
    if x.isdigit():
        print(poke_id[int(x)])
    else:
        print(poke_name[x])