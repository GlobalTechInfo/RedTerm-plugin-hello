# RedTerm plugin: Hello

A reference plugin for [RedTerm](https://github.com/GlobalTechInfo/RedTerm). It
exists to prove the plugin path works end to end: discovery, the consent screen,
and installation as an ordinary app.

It does nothing beyond that, so any problem is with the plumbing.

## How a plugin declares itself

An activity that answers `com.redtermapp.action.PLUGIN` and carries
`com.redtermapp.plugin` metadata:

```xml
<intent-filter>
    <action android:name="com.redtermapp.action.PLUGIN" />
    <category android:name="android.intent.category.DEFAULT" />
</intent-filter>
<meta-data
    android:name="com.redtermapp.plugin"
    android:value='{"id":"hello","name":"Hello","version":"1.0","apiVersion":1,"capabilities":[]}' />
```

Discovery needs no permission, because RedTerm still requires a per-plugin
grant before the plugin can do anything.

## Notes for plugin authors

- `apiVersion` must be a version RedTerm supports. A newer one is listed but
  cannot be enabled, rather than appearing to work.
- Capabilities are a declaration to the user, not a mechanism. A granted plugin
  can do anything RedTerm can, so declare honestly.
- Once enabled, a plugin is an ordinary terminal session: its output shares the
  terminal and the session is disposable like any other.
