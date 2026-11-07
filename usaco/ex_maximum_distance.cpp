#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  vector<int> x, y;
  cin >> n;
  for (int i = 0; i < n; i++)
  {
    int n;
    cin >> n;
    x.push_back(n);
  }
  for (int i = 0; i < n; i++)
  {
    int n;
    cin >> n;
    y.push_back(n);
  }
  int ans = 0;
  for (int i = 0; i < n; i++)
  {
    for (int j = i + 1; j < n; j++)
    {
      int dist = pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2);
      ans = max(ans, dist);
    }
  }
  cout << ans << endl;
}