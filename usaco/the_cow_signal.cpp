#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);
  freopen("cowsignal.in", "r", stdin);
  freopen("cowsignal.out", "w", stdout);
  int m, n, k;
  cin >> m >> n >> k;
  vector<vector<char>> map;
  for (int i = 0; i < m; i++)
  {
    vector<char> row;
    for (int j = 0; j < n; j++)
    {
      char c;
      cin >> c;
      row.push_back(c);
    }
    map.push_back(row);
  }
  vector<vector<char>> new_map;
  for (int i = 0; i < m; i++)
  {
    vector<char> row;
    for (int j = 0; j < n; j++)
    {
      for (int x = 0; x < k; x++)
      {
        row.push_back(map[i][j]);
      }
    }
    for (int x = 0; x < k; x++)
    {
      new_map.push_back(row);
    }
  }
  for (int i = 0; i < new_map.size(); i++)
  {
    for (int j = 0; j < new_map[0].size(); j++)
    {
      cout << new_map[i][j];
    }
    cout << endl;
  }
}