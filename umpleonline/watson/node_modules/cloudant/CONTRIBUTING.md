# Contributor License Agreement

In order for us to accept pull-requests, the contributor must first complete a Contributor License Agreement (CLA). This clarifies the intellectual property license granted with any contribution. It is for your protection as a Contributor as well as the protection of IBM and its customers; it does not change your rights to use your own Contributions for any other purpose.

This is a quick process: one option is signing using Preview on a Mac, then sending a copy to us via email. Signing this agreement covers both CDTDatastore and sync-android.

You can download the CLAs here:

 - [Individual](http://cloudant.github.io/cloudant-sync-eap/cla/cla-individual.pdf)
 - [Corporate](http://cloudant.github.io/cloudant-sync-eap/cla/cla-corporate.pdf)

If you are an IBMer, please contact us directly as the contribution process is slightly different.

# Contributing

Everyone is welcome to contribute with patches, bug-fixes and new features

1. Create an [issue](http://github.com/cloudant/nodejs-cloudant/issues) on github so the community can comment on your idea
2. Fork `nano` in github
3. Create a new branch `git checkout -b my_branch`
4. Create tests for the changes you made
5. Make sure you pass both existing and newly inserted tests
6. Commit your changes
7. Push to your branch `git push origin my_branch`
8. Create a pull request

To run tests make sure you npm test but also run tests without mocks:

``` sh
npm run test-cloudant
```

You can add verbose debug messages while running tests by doing:

```
DEBUG=* node your_nano_scripts.js
```

You can turn nocks on and off using the `NOCK_OFF` environment variable.
