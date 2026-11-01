#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  freopen("pails.in", "r", stdin);
  freopen("pails.out", "w", stdout);
  int x, y, m;
  cin >> x >> y >> m;
  int ans = 0;
  for (int i = 0; i <= m; i++)
  {
    for (int j = 0; j <= m; j++)
    {
      int n = i * x + j * y;
      if (n > m)
      {
        break;
      }
      ans = max(ans, n);
    }
  }
  cout << ans << endl;
}