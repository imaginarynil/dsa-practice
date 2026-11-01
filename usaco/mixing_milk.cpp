#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  freopen("mixmilk.in", "r", stdin);
  freopen("mixmilk.out", "w", stdout);
  vector<int> capacities(3);
  vector<int> milks(3);
  for (int i = 0; i < 3; i++)
  {
    scanf("%d %d", &capacities[i], &milks[i]);
  }
  for (int i = 0; i < 100; i++)
  {
    int a = i % 3;
    int b = (i + 1) % 3;
    int amt = min(capacities[b] - milks[b], milks[a]);
    milks[a] -= amt;
    milks[b] += amt;
  }
  printf("%d\n%d\n%d\n", milks[0], milks[1], milks[2]);
}